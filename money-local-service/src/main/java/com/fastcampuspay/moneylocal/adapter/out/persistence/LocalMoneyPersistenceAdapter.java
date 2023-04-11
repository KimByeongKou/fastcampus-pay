package com.fastcampuspay.moneylocal.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.moneylocal.application.port.out.RechargeMoneyPort;
import com.fastcampuspay.moneylocal.domain.MemberMoney;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class LocalMoneyPersistenceAdapter implements RechargeMoneyPort {

//	private final SpringDataRechargeMoneyRepository rechargeMoneyRepository;
//	 private final RechargeMoneyMapper rechargeMoneyMapper;

	@Override
	public void rechargeMoney(MemberMoney.MemberMoneyId memberMoneyId) {

	}
}
