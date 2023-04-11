package com.fastcampuspay.settlement.application.service;


import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.settlement.application.port.in.RechargeMoneyCommand;
import com.fastcampuspay.settlement.application.port.in.RechargeMoneyUseCase;
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




