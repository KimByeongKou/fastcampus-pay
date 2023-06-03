package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.domain.Membership;

public interface FindMembershipPort {
    MembershipJpaEntity findMembership(
            Membership.MembershipId membershipId
    );
}
