package com.fastcampuspay.remittance.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class GetRemittanceController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@GetMapping(path = "/remittance/info")
	ResponseEntity<Object>  getRemittanceInfoController(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}


	@GetMapping(path = "/remittance/history")
	ResponseEntity<Object>  getRemittanceHistoryController(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
