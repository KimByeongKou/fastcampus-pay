package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.application.port.in.UpdateMembershipCommand;
import com.fastcampuspay.membership.application.port.in.UpdateMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.UpdateMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class UpdateMembership implements UpdateMembershipUseCase {

	private final UpdateMembershipPort uport;

	@Override
	public Membership updateMembership(UpdateMembershipCommand command) {
		return uport.updateMembership(
				new Membership.MembershipId(command.getMembershipId()),
				new Membership.MembershipName(command.getName()),
				new Membership.MembershipEmail(command.getEmail()),
				new Membership.MembershipAddress(command.getAddress()),
				new Membership.MembershipIsValid(command.isValid())
		);
	}
}




