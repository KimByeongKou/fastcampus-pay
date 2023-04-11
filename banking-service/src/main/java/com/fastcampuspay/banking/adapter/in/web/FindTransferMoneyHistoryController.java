package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.banking.domain.BankingAccountRegisterInfo;
import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class FindTransferMoneyHistoryController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@PostMapping(path = "/banking/account/")
	ResponseEntity<BankingAccountRegisterInfo> getTransferMoneyHistory(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
