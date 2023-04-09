package com.fastcampuspay.remittance.application.port.out;


import com.fastcampuspay.remittance.domain.RemittanceMoney;

public interface RemittanceMoneyPort {

	void remittanceMoney(
			RemittanceMoney.RemittanceMoneyId remittanceMoneyId
	);
}
