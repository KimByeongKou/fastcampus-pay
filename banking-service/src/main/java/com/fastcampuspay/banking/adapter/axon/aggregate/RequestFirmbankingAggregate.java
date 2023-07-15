package com.fastcampuspay.banking.adapter.axon.aggregate;

import com.fastcampuspay.banking.adapter.axon.command.CreateRequestFirmbankingCommand;
import com.fastcampuspay.banking.adapter.axon.command.UpdateRequestFirmbankingCommand;
import com.fastcampuspay.banking.adapter.axon.event.RequestFirmbankingCreatedEvent;
import com.fastcampuspay.banking.adapter.axon.event.UpdateRequestFirmbankingEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Table(name = "request_firmbanking")
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
