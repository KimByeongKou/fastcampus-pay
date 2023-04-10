package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.application.port.in.GetMembershipCommand;
import com.fastcampuspay.membership.application.port.in.GetMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.GetMembershipPort;
import com.fastcampuspay.membership.application.port.out.query.GetMembershipQuery;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetMembership implements GetMembershipUseCase {

	private final GetMembershipPort gport;

	private final QueryGateway queryGateway;
	@Override
	public Membership getMembership(GetMembershipCommand command) {
		return gport.getMembership(new Membership.MembershipId(command.getMembershipId()));
	}

	@Override
	public Membership getAxonMembership(GetMembershipCommand command) {
		GetMembershipQuery getQuery = new GetMembershipQuery(command.getMembershipId());
		queryGateway.query(getQuery, ResponseTypes.instanceOf(Membership.class))
				.whenComplete((Object result, Throwable throwable) -> {
					if (throwable == null) {
						System.out.println(result.toString());
					}
					System.out.println("error : " + throwable.getMessage());
				});
		return null;
	}
}




