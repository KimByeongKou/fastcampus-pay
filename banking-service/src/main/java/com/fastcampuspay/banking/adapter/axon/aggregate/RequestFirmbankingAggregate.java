package com.fastcampuspay.banking.adapter.axon.aggregate;

import com.fastcampuspay.banking.adapter.axon.command.CreateRequestFirmbankingCommand;
import com.fastcampuspay.banking.adapter.axon.command.UpdateRequestFirmbankingCommand;
import com.fastcampuspay.banking.adapter.axon.event.RequestFirmbankingCreatedEvent;
import com.fastcampuspay.banking.adapter.axon.event.UpdateRequestFirmbankingEvent;
import com.fastcampuspay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.fastcampuspay.banking.adapter.out.external.bank.FirmbankingResult;
import com.fastcampuspay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.fastcampuspay.banking.application.port.out.RequestFirmbankingPort;
import com.fastcampuspay.banking.domain.FirmbankingRequest;
import com.fastcampuspay.common.command.RequestFirmbankingCommand;
import com.fastcampuspay.common.command.RollbackFirmbankingRequestCommand;
import com.fastcampuspay.common.event.RequestFirmbankingFinishedEvent;
import com.fastcampuspay.common.event.RollbackFirmbankingFinishedEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate()
@Data
public class RequestFirmbankingAggregate {
    @AggregateIdentifier
    private String id;

    private String fromBankName;

    private String fromBankAccountNumber;

    private String toBankName;

    private String toBankAccountNumber;

    private int moneyAmount;

    private int firmbankingStatus;

    @CommandHandler
    public RequestFirmbankingAggregate(@NotNull CreateRequestFirmbankingCommand command) {
        System.out.println("CreateRequestFirmbankingCommand Handler");

        // store event
        apply(new RequestFirmbankingCreatedEvent(command.getFromBankName(), command.getFromBankAccountNumber(), command.getToBankName(), command.getToBankAccountNumber(), command.getMoneyAmount()));
    }

    @CommandHandler
    public String handle(@NotNull UpdateRequestFirmbankingCommand command) {
        System.out.println("UpdateRequestFirmbankingCommand Handler");
        id = command.getAggregateIdentifier();

        // store event
        apply(new UpdateRequestFirmbankingEvent(command.getFirmbankingStatus()));
        return id;
    }

    @CommandHandler
    public RequestFirmbankingAggregate(@NotNull RollbackFirmbankingRequestCommand command, RequestFirmbankingPort firmbankingPort, RequestExternalFirmbankingPort externalFirmbankingPort) {
        System.out.println("RollbackFirmbankingRequestCommand Handler");
        id = UUID.randomUUID().toString();

        firmbankingPort.createFirmbankingRequest(
                new FirmbankingRequest.FromBankName("fastcampus-bank"),
                new FirmbankingRequest.FromBankAccountNumber("123-333-9999"),
                new FirmbankingRequest.ToBankName(command.getBankName()),
                new FirmbankingRequest.ToBankAccountNumber(command.getBankAccountNumber()),
                new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmbankingRequest.FirmbankingStatus(0),
                new FirmbankingRequest.FirmbankingAggregateIdentifier(id));

        // firmbanking!
        externalFirmbankingPort.requestExternalFirmbanking(
                new ExternalFirmbankingRequest(
                "fastcampus",
                        "123-333-9999",
                command.getBankName(),
                command.getBankAccountNumber(),
                command.getMoneyAmount()
        ));

        apply(new RollbackFirmbankingFinishedEvent(
                command.getRollbackFirmbankingId(),
                command.getMembershipId(),
                id)
        );
    }

    @CommandHandler
    public RequestFirmbankingAggregate(RequestFirmbankingCommand command, RequestFirmbankingPort firmbankingPort, RequestExternalFirmbankingPort externalFirmbankingPort){
        System.out.println("RequestFirmbankingCommand Handler");
        id = command.getAggregateIdentifier();

        firmbankingPort.createFirmbankingRequest(
                new FirmbankingRequest.FromBankName(command.getToBankName()),
                new FirmbankingRequest.FromBankAccountNumber(command.getToBankAccountNumber()),
                new FirmbankingRequest.ToBankName("fastcampus-bank"),
                new FirmbankingRequest.ToBankAccountNumber("123-333-9999"),
                new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmbankingRequest.FirmbankingStatus(0),
                new FirmbankingRequest.FirmbankingAggregateIdentifier(id));

        // firmbanking!
        FirmbankingResult firmbankingResult = externalFirmbankingPort.requestExternalFirmbanking(new ExternalFirmbankingRequest(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber(),
                command.getMoneyAmount()
        ));

        int resultCode = firmbankingResult.getResultCode();

        // 0. 성공, 1. 실패
        apply(new RequestFirmbankingFinishedEvent(
                command.getRequestFirmbankingId(),
                command.getRechargeRequestId(),
                command.getMembershipId(),
                command.getToBankName(),
                command.getToBankAccountNumber(),
                command.getMoneyAmount(),
                resultCode,
                id
        ));
    }

    @EventSourcingHandler
    public void on(RequestFirmbankingCreatedEvent event) {
        System.out.println("RequestFirmbankingCreatedEvent Sourcing Handler");
        id = UUID.randomUUID().toString();
        fromBankName = event.getFromBankName();
        fromBankAccountNumber = event.getFromBankAccountNumber();
        toBankName = event.getToBankName();
        toBankAccountNumber = event.getToBankAccountNumber();
    }

    @EventSourcingHandler
    public void on(UpdateRequestFirmbankingEvent event) {
        System.out.println("UpdateRequestFirmbankingEvent Sourcing Handler");
        firmbankingStatus = event.getFirmbankingStatus();
    }

    public RequestFirmbankingAggregate() {
    }
}
