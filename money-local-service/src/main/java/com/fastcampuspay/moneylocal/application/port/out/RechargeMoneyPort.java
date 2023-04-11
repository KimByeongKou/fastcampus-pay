package com.fastcampuspay.moneylocal.application.port.out;


import com.fastcampuspay.moneylocal.domain.MemberMoney;

public interface RechargeMoneyPort {

	void rechargeMoney(
			MemberMoney.MemberMoneyId memberMoneyId
	);
}
