package com.fastcampuspay.settlement.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoney {
	/**
	 * The baseline balance of the account. This was the balance of the account before the first
	 * activity in the activityWindow.
	 */
	@Getter private final String memberMoneyId;
//	@Getter private final String name;
//	@Getter private final String email;
//	@Getter private final String address;
//	@Getter private final boolean isValid;

	public static MemberMoney generateMemberMoney(
			MemberMoneyId memberMoneyId) {
		return new MemberMoney(
				memberMoneyId.getMemberMoneyId()
		);
	}

	@Value
	public static class MemberMoneyId {
		public MemberMoneyId(String value) {
			this.memberMoneyId = value;
		}
		String memberMoneyId ;
	}
}
