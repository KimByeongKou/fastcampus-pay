package com.fastcampuspay.remittance.application.service;


import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.remittance.application.port.in.RemittanceMoneyCommand;
import com.fastcampuspay.remittance.application.port.in.RemittanceMoneyUseCase;
import com.fastcampuspay.remittance.application.port.out.RemittanceMoneyPort;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RemittanceMoney implements RemittanceMoneyUseCase {

	private final RemittanceMoneyPort rport;

	@Override
	public void remittanceMoney(RemittanceMoneyCommand command) {

	}
}




