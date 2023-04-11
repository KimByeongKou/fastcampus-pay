package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.application.port.in.UpdateMembershipCommand;
import com.fastcampuspay.membership.application.port.in.UpdateMembershipEventCommand;
import com.fastcampuspay.membership.application.port.in.UpdateMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.GetMembershipPort;
import com.fastcampuspay.membership.application.port.out.UpdateMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class UpdateMembership implements UpdateMembershipUseCase {

	private final UpdateMembershipPort uport;
	private final GetMembershipPort gport;
	private final CommandGateway commandGateway;
	@Override
	public Membership updateMembership(UpdateMembershipCommand command) {
		return uport.updateMembership(
				new Membership.MembershipId(command.getMembershipId()),
				new Membership.MembershipName(command.getName()),
				new Membership.MembershipEmail(command.getEmail()),
				new Membership.MembershipAddress(command.getAddress()),
				new Membership.MembershipIsValid(command.isValid())
		);
	}

	@Override
	public Membership updateAxonMembership(UpdateMembershipCommand command) {
		System.out.println("update axon membership");
		Membership membership = gport.getMembership(new Membership.MembershipId(command.getMembershipId()));
		UpdateMembershipEventCommand eventCommand = UpdateMembershipEventCommand.builder()
				.aggregateIdentifier(membership.getAggregateIdentifier())
				.name(command.getName())
				.email(command.getEmail())
				.address(command.getAddress())
				.isValid(command.isValid())
				.build();

		commandGateway.send(eventCommand).whenComplete((Object result, Throwable throwable) -> {
				if (throwable == null) {
					System.out.println("Aggregate ID:" + result);
				} else {
					System.out.println("error : " + throwable.getMessage());
				}
			});

		this.updateMembership(command);
		return null;
	}
}




