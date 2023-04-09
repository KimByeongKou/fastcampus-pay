package com.fastcampuspay.remittance.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class RequestRemittanceMoneyController {

	// private final RechargeMoneyUseCase registerBankingAccountUseCase;

	@PostMapping(path = "/remittance/request/")
	ResponseEntity<Object> requestRemittanceMoneyController(){
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
