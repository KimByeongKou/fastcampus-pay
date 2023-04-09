package com.fastcampuspay.money.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class RechargeMoneyController {

	// private final RechargeMoneyUseCase registerBankingAccountUseCase;

	@PostMapping(path = "/money/recharge/")
	ResponseEntity<Object> rechargeMoney(){
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
