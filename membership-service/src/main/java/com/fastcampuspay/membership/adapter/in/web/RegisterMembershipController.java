package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.application.port.in.GetMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
class RegisterMembershipController {

	private final RegisterMembershipUseCase registerMembershipUseCase;
	@PostMapping(path = "/membership/register/")
	void registerMembership(@RequestBody RegisterMembershipRequest request){
		// RegisterMembershipRequest
		// name, address, email
		RegisterMembershipCommand command = RegisterMembershipCommand.builder()
				.name(request.getName())
				.address(request.getAddress())
				.email(request.getEmail())
				.build();
		registerMembershipUseCase.registerMembership(command);
	}


	@PostMapping(path = "/membership/axon-register/")
	void getAxonMembership(@RequestBody RegisterMembershipRequest request){
		RegisterMembershipCommand command = RegisterMembershipCommand.builder()
				.name(request.getName())
				.address(request.getAddress())
				.email(request.getEmail())
				.build();

		registerMembershipUseCase.registerAxonMembership(command);
	}
}
