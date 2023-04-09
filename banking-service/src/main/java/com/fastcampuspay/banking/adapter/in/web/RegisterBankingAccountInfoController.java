package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.banking.application.port.in.RegisterBankingAccountCommand;
import com.fastcampuspay.banking.application.port.in.RegisterBankingAccountUseCase;
import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class RegisterBankingAccountInfoController {

	private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@PostMapping(path = "/banking/account/")
	void registerBankingAccount(@RequestBody RegisterBankingAccountInfoRequest request){
		// RegisterMembershipRequest
		// name, address, email
		RegisterBankingAccountCommand command = RegisterBankingAccountCommand.builder()
				.name(request.getName())
				.address(request.getAddress())
				.email(request.getEmail())
				.build();
		registerBankingAccountUseCase.registerBankingAccount(command);
	}

}
