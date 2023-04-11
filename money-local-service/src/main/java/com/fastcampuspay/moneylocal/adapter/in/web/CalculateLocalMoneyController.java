package com.fastcampuspay.moneylocal.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// CQRS Controller
@WebAdapter
@RestController
@RequiredArgsConstructor
class CalculateLocalMoneyController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@GetMapping(path = "/money-local/calculate-money-sum")
	ResponseEntity<Object>  calculateMoneySumByLocal(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	// TODO
	// - MembershipUpdate EventHandler (EventHandler)
}
