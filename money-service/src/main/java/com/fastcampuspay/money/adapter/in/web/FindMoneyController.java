package com.fastcampuspay.money.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class FindMoneyController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@GetMapping(path = "/money/money-history")
	ResponseEntity<Object>  findMoneyHistoryByMemberId(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(path = "/money/money-info")
	ResponseEntity<Object>  findMoneyInfoByRechargeMoneyId(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}


}
