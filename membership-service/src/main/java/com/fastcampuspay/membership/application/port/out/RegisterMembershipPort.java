package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.domain.Membership;

public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(
        Membership.MembershipName membershipName
        , Membership.MembershipEmail membershipEmail
        , Membership.MembershipAddress membershipAddress
        , Membership.MembershipIsValid membershipIsValid
            ,Membership.MembershipIsCorp membershipIsCorp
    );
}
