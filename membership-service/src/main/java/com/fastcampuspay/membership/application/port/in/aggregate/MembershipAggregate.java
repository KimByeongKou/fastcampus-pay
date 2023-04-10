package com.fastcampuspay.membership.application.port.in.aggregate;

import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.saga.MembershipCreateEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;


@Aggregate()
@Data
public class MembershipAggregate {
    @AggregateIdentifier
    private String id;
    private String name;

    private String email;

    private String address;

    @CommandHandler
    public MembershipAggregate(@NotNull RegisterMembershipCommand command) {
        System.out.println("RegisterMembershipCommand Handler");

        // store event
        apply(new MembershipCreateEvent(command.getName(), command.getEmail(), command.getAddress()));
    }

    @EventSourcingHandler
    public void on(MembershipCreateEvent event) {
        System.out.println("MembershipCreatedEvent Sourcing Handler");
        id = UUID.randomUUID().toString();
        name = event.getName() ;
        email = event.getEmail();
        address = event.getAddress();
    }

    public MembershipAggregate() {
        // Required by Axon to construct an empty instance to initiate Event Sourcing.
    }

    @Override
    public String toString() {
        return "MembershipAggregate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

