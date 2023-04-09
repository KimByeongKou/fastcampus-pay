package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.application.port.in.GetMembershipCommand;
import com.fastcampuspay.membership.application.port.in.GetMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.GetMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetMembership implements GetMembershipUseCase {

	private final GetMembershipPort gport;

	@Override
	public Membership getMembership(GetMembershipCommand command) {
		return gport.getMembership(new Membership.MembershipId(command.getMembershipId()));
	}
}




