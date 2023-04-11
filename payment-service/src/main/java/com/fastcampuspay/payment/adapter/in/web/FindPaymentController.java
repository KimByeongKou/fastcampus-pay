package com.fastcampuspay.payment.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class FindPaymentController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@GetMapping(path = "/payment/info")
	ResponseEntity<Object>  findPaymentByPaymentId(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(path = "/payment/list-by-period")
	ResponseEntity<Object>  listPaymentsByPeriod(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}


}
