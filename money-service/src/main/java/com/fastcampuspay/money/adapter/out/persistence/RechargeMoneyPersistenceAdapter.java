package com.fastcampuspay.money.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.money.application.port.out.RechargeMoneyPort;
import com.fastcampuspay.money.domain.MemberMoney;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class RechargeMoneyPersistenceAdapter implements RechargeMoneyPort {

	private final SpringDataRechargeMoneyRepository rechargeMoneyRepository;
	 private final RechargeMoneyMapper rechargeMoneyMapper;

	private Long orZero(Long value){
		return value == null ? 0L : value;
	}


	@Override
	public void rechargeMoney(MemberMoney.MemberMoneyId memberMoneyId) {

	}
}
