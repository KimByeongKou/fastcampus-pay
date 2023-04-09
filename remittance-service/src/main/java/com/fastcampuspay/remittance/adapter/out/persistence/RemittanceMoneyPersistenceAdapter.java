package com.fastcampuspay.remittance.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.remittance.application.port.out.RemittanceMoneyPort;
import com.fastcampuspay.remittance.domain.RemittanceMoney;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class RemittanceMoneyPersistenceAdapter implements RemittanceMoneyPort {

	private final SpringDataRemittanceMoneyRepository remittanceMoneyRepository;
	 private final RemittanceMoneyMapper remittanceMoneyMapper;

	private Long orZero(Long value){
		return value == null ? 0L : value;
	}

	@Override
	public void remittanceMoney(RemittanceMoney.RemittanceMoneyId remittanceMoneyId) {

	}
}
