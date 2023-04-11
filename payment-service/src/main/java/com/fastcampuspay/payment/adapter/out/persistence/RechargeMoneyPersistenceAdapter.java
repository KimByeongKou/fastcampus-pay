package com.fastcampuspay.payment.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.payment.application.port.out.RechargeMoneyPort;
import com.fastcampuspay.payment.domain.MemberMoney;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class PaymentPersistenceAdapter implements RechargeMoneyPort {

//	private final SpringDataRechargeMoneyRepository rechargeMoneyRepository;
//	private final RechargeMoneyMapper rechargeMoneyMapper;


	@Override
	public void rechargeMoney(MemberMoney.MemberMoneyId memberMoneyId) {

	}
}
