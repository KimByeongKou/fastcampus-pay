package com.fastcampuspay.remittance.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RemittanceMoney {
	/**
	 * The baseline balance of the account. This was the balance of the account before the first
	 * activity in the activityWindow.
	 */
	@Getter private final String memberMoneyId;
//	@Getter private final String name;
//	@Getter private final String email;
//	@Getter private final String address;
//	@Getter private final boolean isValid;

	public static RemittanceMoney generateRemittanceMoney(
			RemittanceMoneyId memberMoneyId) {
		return new RemittanceMoney(
				memberMoneyId.getRemittanceMoney()
		);
	}

	@Value
	public static class RemittanceMoneyId {
		public RemittanceMoneyId(String value) {
			this.remittanceMoney = value;
		}
		String remittanceMoney ;
	}
}
