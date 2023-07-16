package com.fastcampuspay.banking.adapter.axon.aggregate;

import com.fastcampuspay.banking.adapter.axon.command.CreateFirmbankingRequestCommand;
import com.fastcampuspay.banking.adapter.axon.command.UpdateFirmbankingRequestCommand;
import com.fastcampuspay.banking.adapter.axon.event.FirmbankingRequestCreatedEvent;
import com.fastcampuspay.banking.adapter.axon.event.FirmbankingRequestUpdatedEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate()
@Data
public class FirmbankingRequestAggregate {

    @AggregateIdentifier
    private String id;

    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private int moneyAmount;
    private int firmbankingStatus;

    @CommandHandler
    public FirmbankingRequestAggregate (CreateFirmbankingRequestCommand command) {
        System.out.println("CreateFirmbankingRequestCommand Handler");
        apply(new FirmbankingRequestCreatedEvent(command.getFromBankName(), command.getFromBankAccountNumber(), command.getToBankName(), command.getToBankAccountNumber(), command.getMoneyAmount()));
    }

    @CommandHandler
    public String handle(UpdateFirmbankingRequestCommand command) {
        System.out.println("UpdateFirmbankingRequestCommand Handler");

        id = command.getAggregateIdentifier();
        apply(new FirmbankingRequestUpdatedEvent(command.getFirmbankingStatus()));

        return id;
    }

    @EventSourcingHandler
    public void on (FirmbankingRequestCreatedEvent event) {
        System.out.println("FirmbankingRequestCreatedEvent Sourcing Handler");
        id = UUID.randomUUID().toString();
        fromBankName = event.getFromBankName();
        fromBankAccountNumber = event.getFromBankAccountNumber();
        toBankName = event.getToBankName();
        toBankAccountNumber = event.getToBankAccountNumber();
    }

    @EventSourcingHandler
    public void on (FirmbankingRequestUpdatedEvent event) {
        System.out.println("FirmbankingRequestUpdatedEvent Sourcing Handler");
        firmbankingStatus = event.getFirmbankingStatus();
    }

    public FirmbankingRequestAggregate() {
    }
}
