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
class FindRemittanceController {

	// private final RegisterBankingAccountUseCase registerBankingAccountUseCase;

	@GetMapping(path = "/remittance/info")
	ResponseEntity<Object>  findRemittanceInfoByRemittanceId(){


		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}


	@GetMapping(path = "/remittance/history")
	ResponseEntity<Object>  findRemittanceHistoryByMemberId(){


		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	// (API Aggregation, Banking + Money)
	@GetMapping(path = "/remittance/transferred-money")
	ResponseEntity<Object>  findMoneyTransferringByRemittanceId(){


		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
}
