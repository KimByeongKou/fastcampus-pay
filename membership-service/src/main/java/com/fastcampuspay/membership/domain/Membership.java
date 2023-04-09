package com.fastcampuspay.membership.domain;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {
	/**
	 * The baseline balance of the account. This was the balance of the account before the first
	 * activity in the activityWindow.
	 */
	@Getter private final String membershipId;
	@Getter private final String name;
	@Getter private final String email;
	@Getter private final String address;
	@Getter private final boolean isValid;

	public static Membership generateMember(
			MembershipId membershipId, MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid) {
		return new Membership(
				membershipId.membershipId,
				membershipName.nameValue,
				membershipEmail.emailValue,
				membershipAddress.addressValue,
				membershipIsValid.isValidValue
		);
	}

	@Value
	public static class MembershipId {
		public MembershipId(String value) {
			this.membershipId = value;
		}
		String membershipId ;
	}

	@Value
	public static class MembershipName {
		public MembershipName(String value) {
			this.nameValue = value;
		}

		String nameValue;
	}
	@Value
	public static class MembershipEmail {
		public MembershipEmail(String value) {
			this.emailValue = value;
		}
		String emailValue;
	}

	@Value
	public static class MembershipAddress {
		public MembershipAddress(String value) {
			this.addressValue = value;
		}
		String addressValue;
	}

	@Value
	public static class MembershipIsValid {
		public MembershipIsValid(boolean value) {
			this.isValidValue = value;
		}
		boolean isValidValue;
	}
}
