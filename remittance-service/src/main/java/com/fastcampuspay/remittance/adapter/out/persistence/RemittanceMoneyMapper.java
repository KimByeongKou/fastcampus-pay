package com.fastcampuspay.remittance.adapter.out.persistence;

import com.fastcampuspay.remittance.domain.RemittanceMoney;
import org.springframework.stereotype.Component;

@Component
class RemittanceMoneyMapper {
	RemittanceMoney mapToDomainEntity(
			RemittanceMoneyJpaEntity remittanceMoneyJpaEntity) {
		System.out.println(remittanceMoneyJpaEntity.toString());
		return RemittanceMoney.generateRemittanceMoney(
				new RemittanceMoney.RemittanceMoneyId(remittanceMoneyJpaEntity.getRemittanceMoneyId()+"")
				);
	}
}
