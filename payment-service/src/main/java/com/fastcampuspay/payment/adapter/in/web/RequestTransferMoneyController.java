package com.fastcampuspay.payment.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class RequestTransferMoneyController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@PostMapping(path = "/payment/request")
	ResponseEntity<Object> requestPaymentAtMerchant(){
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
