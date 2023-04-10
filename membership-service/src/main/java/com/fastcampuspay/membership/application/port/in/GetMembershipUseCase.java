package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.membership.domain.Membership;

public interface GetMembershipUseCase {

	Membership getMembership(GetMembershipCommand command);
	Membership getAxonMembership(GetMembershipCommand command);
}
