package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.domain.Membership;

public interface UpdateMembershipPort {

	Membership updateMembership(
			Membership.MembershipId membershipId
			, Membership.MembershipName membershipName
			, Membership.MembershipEmail membershipEmail
			, Membership.MembershipAddress membershipAddress
			, Membership.MembershipIsValid membershipIsValid
	);
}
