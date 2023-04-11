package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.membership.application.port.in.GetMembershipCommand;
import com.fastcampuspay.membership.application.port.in.GetMembershipUseCase;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class GetMembershipController {

	private final GetMembershipUseCase getMembershipUseCase;



	@GetMapping(path = "/membership/{membershipId}")
	ResponseEntity<Membership> getMembership(@PathVariable String membershipId){
		// getMembership
		GetMembershipCommand command = GetMembershipCommand.builder()
				.membershipId(membershipId)
				.build();
		return ResponseEntity.ok(getMembershipUseCase.getMembership(command));
	}

	@GetMapping(path = "/membership/axon/{membershipId}")
	ResponseEntity<Membership> getAxonMembership(@PathVariable String membershipId){
		// getMembership
		GetMembershipCommand command = GetMembershipCommand.builder()
				.membershipId(membershipId)
				.build();

		return ResponseEntity.ok(getMembershipUseCase.getAxonMembership(command));
	}


}
