package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.domain.Membership;

public interface RegisterMembershipPort {

	void createMembership(
			Membership.MembershipName membershipName
			, Membership.MembershipEmail membershipEmail
			, Membership.MembershipAddress membershipAddress
			, Membership.MembershipIsValid membershipIsValid
	);
}
