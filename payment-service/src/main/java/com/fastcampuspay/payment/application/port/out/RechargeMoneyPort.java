package com.fastcampuspay.payment.application.port.out;


import com.fastcampuspay.payment.domain.MemberMoney;

public interface RechargeMoneyPort {

	void rechargeMoney(
			MemberMoney.MemberMoneyId memberMoneyId
	);
}
