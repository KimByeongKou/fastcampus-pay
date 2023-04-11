package com.fastcampuspay.settlement.adapter.out.persistence;

import com.fastcampuspay.settlement.domain.MemberMoney;
import org.springframework.stereotype.Component;

@Component
class SettlementMapper {
	MemberMoney mapToDomainEntity(
			SettlementJpaEntity rechargeMoneyJpaEntity) {
		System.out.println(rechargeMoneyJpaEntity.toString());
		return MemberMoney.generateMemberMoney(
				new MemberMoney.MemberMoneyId(rechargeMoneyJpaEntity.getRechargeMoneyId()+"")
				);
	}
}
