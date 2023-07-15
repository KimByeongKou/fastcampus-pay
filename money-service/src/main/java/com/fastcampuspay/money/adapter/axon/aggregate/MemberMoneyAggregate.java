package com.fastcampuspay.money.adapter.axon.aggregate;

import com.fastcampuspay.money.adapter.axon.command.CreateMoneyCommand;
import com.fastcampuspay.money.adapter.axon.command.IncreaseMoneyRequestEventCommand;
import com.fastcampuspay.money.adapter.axon.command.RechargingMoneyRequestCreateCommand;
import com.fastcampuspay.money.adapter.axon.event.IncreaseMoneyEvent;
import com.fastcampuspay.money.adapter.axon.event.MemberMoneyCreateEvent;
import com.fastcampuspay.money.adapter.axon.event.RechargingRequestCreatedEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;


@Table(name = "member_money")
@Aggregate()
@Data
public class MemberMoneyAggregate {
    @AggregateIdentifier
    private String id;

    private Long membershipId;

    private int balance;

    @CommandHandler
    public MemberMoneyAggregate(@NotNull CreateMoneyCommand command) {
        System.out.println("CreateMoneyCommand Handler");
        // store event
        apply(new MemberMoneyCreateEvent(command.getMembershipId()));
    }

    @CommandHandler
    public String handle(@NotNull IncreaseMoneyRequestEventCommand command) {
        System.out.println("IncreaseMoneyRequestEventCommand Handler");
        id = command.getAggregateIdentifier();

        // store event
        apply(new IncreaseMoneyEvent(id, command.getTargetMembershipId(), command.getAmount()));
        return id;
    }
    @CommandHandler
    public void handle(RechargingMoneyRequestCreateCommand command) {
        System.out.println("RechargingMoneyRequestCreateCommand Handler");
        id = command.getAggregateIdentifier();

        apply(new RechargingRequestCreatedEvent(command.getRechargingRequestId(), command.getMembershipId(), command.getAmount()));
        // commandGateway.send(new OrderCreatedEvent(orderId));
    }

    @EventSourcingHandler
    public void on(MemberMoneyCreateEvent event) {
        System.out.println("MemberMoneyCreateEvent Sourcing Handler");
        id = UUID.randomUUID().toString();
        membershipId = Long.parseLong(event.getMembershipId());
        balance = 0;
    }

    @EventSourcingHandler
    public void on(IncreaseMoneyEvent event) {
        System.out.println("IncreaseMoneyEvent Sourcing Handler");
        id = event.getAggregateIdentifier();
        membershipId = Long.parseLong(event.getTargetMembershipId());
        balance = event.getAmount();
    }

    public MemberMoneyAggregate() {
        // Required by Axon to construct an empty instance to initiate Event Sourcing.
    }

    @Override
    public String toString() {
        return "MemberMoneyAggregate{" +
                "id='" + id + '\'' +
                ", membershipId=" + membershipId +
                ", balance=" + balance +
                '}';
    }
}

