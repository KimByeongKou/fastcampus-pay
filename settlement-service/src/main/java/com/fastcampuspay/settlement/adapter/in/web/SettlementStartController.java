package com.fastcampuspay.settlement.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class SettlementStartController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@PostMapping(path = "/settlement/start")
	ResponseEntity<Object> startSettlementByPeriod(){
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
