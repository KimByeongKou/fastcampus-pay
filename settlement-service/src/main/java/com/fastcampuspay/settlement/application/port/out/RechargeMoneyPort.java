package com.fastcampuspay.settlement.application.port.out;


import com.fastcampuspay.settlement.domain.MemberMoney;

public interface RechargeMoneyPort {

	void rechargeMoney(
			MemberMoney.MemberMoneyId memberMoneyId
	);
}
