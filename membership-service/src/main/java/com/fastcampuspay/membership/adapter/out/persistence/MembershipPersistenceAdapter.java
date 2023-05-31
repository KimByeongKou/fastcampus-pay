package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class MembershipPersistenceAdapter implements RegisterMembershipPort {

	private final SpringDataMembershipRepository membershipRepository;

	@Override
	public void createMembership(Membership.MembershipName membershipName
			, Membership.MembershipEmail membershipEmail
			, Membership.MembershipAddress membershipAddress
			, Membership.MembershipIsValid membershipIsValid
			, Membership.MembershipAggregateIdentifier membershipAggregateIdentifier
	) {
		membershipRepository.save(
				new MembershipJpaEntity(
						membershipName.getNameValue(),
						membershipEmail.getEmailValue(),
						membershipAddress.getAddressValue(),
						membershipIsValid.isValidValue(),
						membershipAggregateIdentifier.getAggregateIdentifier()
				)
		);
	}

}
