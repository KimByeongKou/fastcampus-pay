package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.domain.Membership;

public interface FindMembershipPort {

	Membership findMembership(
			Membership.MembershipId membershipId
	);
}
