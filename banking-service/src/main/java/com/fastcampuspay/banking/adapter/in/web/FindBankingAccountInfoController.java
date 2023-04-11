package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class FindBankingAccountInfoController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@GetMapping(path = "/banking/registered-banking-account/")
	ResponseEntity<Object>  findRegisteredBankingAccountByMemberId(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(path = "/banking/transfer-money/")
	ResponseEntity<Object>  findTransferMoneyInfoByMemberId(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(path = "/banking/transfer-money-info/")
	ResponseEntity<Object>  findTransferMoneyInfoByBankingId(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
