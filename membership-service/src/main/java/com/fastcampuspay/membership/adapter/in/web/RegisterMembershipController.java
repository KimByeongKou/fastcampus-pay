package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
