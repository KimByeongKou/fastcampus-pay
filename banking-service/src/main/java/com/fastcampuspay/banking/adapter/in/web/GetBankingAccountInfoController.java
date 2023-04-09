package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.banking.domain.BankingAccountRegisterInfo;
import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class GetBankingAccountInfoController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@GetMapping(path = "/banking/account/{bankingAccountRegisterInfoId}")
	ResponseEntity<BankingAccountRegisterInfo>  getBankingAccountRegisterInfo(@RequestBody String bankingAccountRegisterInfoId){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
