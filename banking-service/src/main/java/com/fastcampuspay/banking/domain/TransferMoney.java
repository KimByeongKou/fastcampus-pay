package com.fastcampuspay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransferMoney {
	/**
	 * The baseline balance of the account. This was the balance of the account before the first
	 * activity in the activityWindow.
	 */
	@Getter private final String transferMoneyId;

	public static TransferMoney generateTransferMoney(
			TransferMoneyId transferMoneyId) {
		return new TransferMoney(
				transferMoneyId.transferMoneyId
		);
	}

	@Value
	public static class TransferMoneyId {
		public TransferMoneyId(String value) {
			this.transferMoneyId = value;
		}
		String transferMoneyId ;
	}
}
