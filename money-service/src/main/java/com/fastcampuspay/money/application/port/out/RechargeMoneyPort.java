package com.fastcampuspay.money.application.port.out;


import com.fastcampuspay.money.domain.MemberMoney;

public interface RechargeMoneyPort {

	void rechargeMoney(
			MemberMoney.MemberMoneyId memberMoneyId
	);
}
