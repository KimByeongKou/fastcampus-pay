package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.membership.application.port.in.UpdateMembershipCommand;
import com.fastcampuspay.membership.application.port.in.UpdateMembershipUseCase;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class UpdateMembershipController {

	private final UpdateMembershipUseCase updateMembershipUseCase;
	private final CommandGateway commandGateway;
	@PutMapping(path = "/membership/update")
	ResponseEntity<Membership> updateMembership(@PathVariable UpdateMembershipRequest membershipToBeUpdated){
		// updateMembership
		UpdateMembershipCommand command = UpdateMembershipCommand.builder()
				.membershipId(membershipToBeUpdated.getMembershipId())
				.name(membershipToBeUpdated.getName())
				.address(membershipToBeUpdated.getAddress())
				.email(membershipToBeUpdated.getEmail())
				.isValid(membershipToBeUpdated.isValid())
				.build();
		return ResponseEntity.ok(updateMembershipUseCase.updateMembership(command));
	}
}
