package com.fastcampuspay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BankingAccountRegisterInfo {
	/**
	 * The baseline balance of the account. This was the balance of the account before the first
	 * activity in the activityWindow.
	 */
	@Getter private final String bankingAccountRegisterInfoId;
//	@Getter private final String name;
//	@Getter private final String email;
//	@Getter private final String address;
//	@Getter private final boolean isValid;

	public static BankingAccountRegisterInfo generateBankingAccountRegisterInfo(
			BankingAccountRegisterInfoId bankingAccountRegisterInfoId) {
		return new BankingAccountRegisterInfo(
				bankingAccountRegisterInfoId.bankingAccountRegisterInfoId
		);
	}

	@Value
	public static class BankingAccountRegisterInfoId {
		public BankingAccountRegisterInfoId(String value) {
			this.bankingAccountRegisterInfoId = value;
		}
		String bankingAccountRegisterInfoId ;
	}
}
