package com.fastcampuspay.money.adapter.out.persistence;

import com.fastcampuspay.money.domain.MemberMoney;
import org.springframework.stereotype.Component;

@Component
class RechargeMoneyMapper {
	MemberMoney mapToDomainEntity(
			RechargeMoneyJpaEntity rechargeMoneyJpaEntity) {
		System.out.println(rechargeMoneyJpaEntity.toString());
		return MemberMoney.generateMemberMoney(
				new MemberMoney.MemberMoneyId(rechargeMoneyJpaEntity.getRechargeMoneyId()+"")
				);
	}
}
