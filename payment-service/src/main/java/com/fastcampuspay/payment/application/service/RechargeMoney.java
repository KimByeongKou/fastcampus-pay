package com.fastcampuspay.payment.application.service;


import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.payment.application.port.in.RechargeMoneyCommand;
import com.fastcampuspay.payment.application.port.in.RechargeMoneyUseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RechargeMoney implements RechargeMoneyUseCase {

	@Override
	public void rechargeMoney(RechargeMoneyCommand command) {

	}
}




