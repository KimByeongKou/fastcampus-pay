package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.domain.Membership;

import java.util.List;

public interface AuthMembershipPort {
    String generateJWTToken (
            Membership.MembershipId membershipId
    );

    String generateRefreshToken (
            Membership.MembershipId membershipId
    );

    boolean validateJWTToken (
            String token
    );

    Membership.MembershipId parseMembershipIdFromToken (
            String token
    );
}
