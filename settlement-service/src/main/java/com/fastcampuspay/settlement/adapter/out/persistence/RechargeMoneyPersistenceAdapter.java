package com.fastcampuspay.settlement.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.settlement.application.port.out.RechargeMoneyPort;
import com.fastcampuspay.settlement.domain.MemberMoney;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class RechargeMoneyPersistenceAdapter implements RechargeMoneyPort {

//	private final SpringDataRechargeMoneyRepository rechargeMoneyRepository;
//	 private final RechargeMoneyMapper rechargeMoneyMapper;
	@Override
	public void rechargeMoney(MemberMoney.MemberMoneyId memberMoneyId) {

	}
}
