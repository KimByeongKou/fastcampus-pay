package com.fastcampuspay.moneylocal.adapter.out.persistence;

import com.fastcampuspay.moneylocal.domain.MemberMoney;
import org.springframework.stereotype.Component;

@Component
class LocalMoneyMapper {
	MemberMoney mapToDomainEntity(
			LocalMoneyJpaEntity rechargeMoneyJpaEntity) {
		System.out.println(rechargeMoneyJpaEntity.toString());
		return MemberMoney.generateMemberMoney(
				new MemberMoney.MemberMoneyId(rechargeMoneyJpaEntity.getRechargeMoneyId()+"")
				);
	}
}
