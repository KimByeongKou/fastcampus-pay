package com.fastcampuspay.payment.adapter.out.persistence;

import com.fastcampuspay.payment.domain.MemberMoney;
import org.springframework.stereotype.Component;

@Component
class PaymentMapper {
	MemberMoney mapToDomainEntity(
			PaymentJpaEntity rechargeMoneyJpaEntity) {
		System.out.println(rechargeMoneyJpaEntity.toString());
		return MemberMoney.generateMemberMoney(
				new MemberMoney.MemberMoneyId(rechargeMoneyJpaEntity.getRechargeMoneyId()+"")
				);
	}
}
