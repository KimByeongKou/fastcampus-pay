package com.fastcampuspay.money.adapter.axon.aggregate;

import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


@Aggregate()
@Data
public class MoneyAggregate {
    @AggregateIdentifier
    private String id;
    private String name;

    private String email;

    private String address;

//    @CommandHandler
//    public MembershipAggregate(@NotNull RegisterMembershipCommand command) {
//        System.out.println("RegisterMembershipCommand Handler");
//
//        // store event
//        apply(new MembershipCreateEvent(command.getName(), command.getEmail(), command.getAddress()));
//    }
//
//    @CommandHandler
//    public String handle(@NotNull UpdateMembershipEventCommand command) {
//        System.out.println("UpdateMembershipEventCommand Handler");
//        id = command.getAggregateIdentifier();
//
//        // store event
//        apply(new MembershipUpdateEvent(id, command.getName(), command.getEmail(), command.getAddress()));
//        return id;
//    }
//
//    @CommandHandler
//    public String handle (@NotNull UpdateMembershipCommand command) {
//        System.out.println("UpdateMembershipCommand Handler");
//        String aggregateIdentifier = command.getMembershipId();
//        id = aggregateIdentifier;
//
//        // store event
//        apply(new MembershipUpdateEvent(aggregateIdentifier, command.getName(), command.getEmail(), command.getAddress()));
//        return aggregateIdentifier;
//    }
//
//    @EventSourcingHandler
//    public void on(MembershipCreateEvent event) {
//        System.out.println("MembershipCreateEvent Sourcing Handler");
//        id = UUID.randomUUID().toString();
//        name = event.getName() ;
//        email = event.getEmail();
//        address = event.getAddress();
//    }
//
//    @EventSourcingHandler
//    public void on(MembershipUpdateEvent event) {
//        System.out.println("MembershipUpdateEvent Sourcing Handler");
//        name = event.getName() ;
//        email = event.getEmail();
//        address = event.getAddress();
//    }
//
//
//    public MembershipAggregate() {
//        // Required by Axon to construct an empty instance to initiate Event Sourcing.
//    }
//
//    @Override
//    public String toString() {
//        return "MembershipAggregate{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }
}

