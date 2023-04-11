package com.fastcampuspay.moneylocal.application.service;


import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.moneylocal.application.port.in.RechargeMoneyCommand;
import com.fastcampuspay.moneylocal.application.port.in.RechargeMoneyUseCase;
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




