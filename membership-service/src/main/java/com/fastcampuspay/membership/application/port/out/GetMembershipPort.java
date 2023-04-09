package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.domain.Membership;

public interface GetMembershipPort {

	Membership getMembership(
			Membership.MembershipId membershipId
	);
}
