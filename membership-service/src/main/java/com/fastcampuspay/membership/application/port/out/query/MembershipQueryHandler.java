package com.fastcampuspay.membership.application.port.out.query;

import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MembershipQueryHandler{

    private final FindMembershipPort fport;

    @QueryHandler
    public Membership handle(FindMembershipQuery query) {
        System.out.println("MembershipQueryHandler Handler");

        // Retrieve the event sourcing repository
//        EventSourcingRepository<MembershipAggregate> repository =  EventSourcingRepository.builder(MembershipAggregate.class).eventStore(eventStore).build();
//        MembershipAggregate user = repository.load(query.getMembershipId()).getWrappedAggregate().getAggregateRoot();

//        System.out.println(user.toString());
        return fport.findMembership(new Membership.MembershipId(query.getMembershipId()));

//        return Membership.generateMember(
//                new Membership.MembershipId(user.getId()+""),
//                new Membership.MembershipName(user.getName()),
//                new Membership.MembershipEmail(user.getEmail()),
//                new Membership.MembershipAddress(user.getAddress()),
//                new Membership.MembershipIsValid(true)
//        );
    }

}