package com.fastcampuspay.membership.application.port.out.query;

import com.fastcampuspay.membership.application.port.in.aggregate.MembershipAggregate;
import com.fastcampuspay.membership.application.port.out.GetMembershipPort;
import com.fastcampuspay.membership.application.saga.MembershipGetEvent;
import com.fastcampuspay.membership.domain.Membership;
import jdk.jfr.Event;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.DomainEventStream;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class MembershipQueryHandler{

    private final GetMembershipPort gport;

    private final EventStore eventStore;

    @QueryHandler
    public Membership handle(GetMembershipQuery query) {
        System.out.println("MembershipQueryHandler Handler");

        // Retrieve the event sourcing repository
        EventSourcingRepository<MembershipAggregate> repository =  EventSourcingRepository.builder(MembershipAggregate.class).eventStore(eventStore).build();
        MembershipAggregate user = repository.load(query.getMembershipId()).getWrappedAggregate().getAggregateRoot();

        System.out.println(user.toString());
        return Membership.generateMember(
                new Membership.MembershipId(user.getId()+""),
                new Membership.MembershipName(user.getName()),
                new Membership.MembershipEmail(user.getEmail()),
                new Membership.MembershipAddress(user.getAddress()),
                new Membership.MembershipIsValid(true)
        );

    }

}