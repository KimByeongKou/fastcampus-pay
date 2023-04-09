package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.membership.application.port.out.GetMembershipPort;
import com.fastcampuspay.membership.application.port.out.UpdateMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class MembershipPersistenceAdapter implements RegisterMembershipPort, GetMembershipPort, UpdateMembershipPort {

	private final SpringDataMembershipRepository membershipRepository;
	 private final MembershipMapper membershipMapper;

	private Long orZero(Long value){
		return value == null ? 0L : value;
	}


	@Override
	public void createMembership(Membership.MembershipName membershipName
			, Membership.MembershipEmail membershipEmail
			, Membership.MembershipAddress membershipAddress
			, Membership.MembershipIsValid membershipIsValid
	) {
		membershipRepository.save(
				new MembershipJpaEntity(
						membershipName.getNameValue(),
						membershipEmail.getEmailValue(),
						membershipAddress.getAddressValue(),
						membershipIsValid.isValidValue()
				)
		);
	}

	@Override
	public Membership getMembership(Membership.MembershipId membershipId) {
		return membershipMapper.mapToDomainEntity(
				membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()))
		);
	}

	@Override
	public Membership updateMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid) {
		// update membership Info
		MembershipJpaEntity membershipJpaEntity = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
		membershipJpaEntity.setName(membershipName.getNameValue());
		membershipJpaEntity.setEmail(membershipEmail.getEmailValue());
		membershipJpaEntity.setAddress(membershipAddress.getAddressValue());
		membershipJpaEntity.setValid(membershipIsValid.isValidValue());

		// save
		MembershipJpaEntity updatedMembership = membershipRepository.save(membershipJpaEntity);

		// return
		return membershipMapper.mapToDomainEntity(updatedMembership);
	}
}
