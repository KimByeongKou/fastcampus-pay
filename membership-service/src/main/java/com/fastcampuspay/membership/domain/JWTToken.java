package com.fastcampuspay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JWTToken {
    @Getter private final String membershipId;
    @Getter private final String jwtToken;
    @Getter private final String refreshToken;

    public static JWTToken generateJWTToken (
            MembershipId membershipId
            , MembershipJWTToken jwtToken
            , MembershipRefreshToken refreshToken
    ){
        return new JWTToken(
                membershipId.getMembershipId(),
                jwtToken.getJwtToken(),
                refreshToken.getRefreshToken()
        );
    }

    @Value
    public static class MembershipId {
        public MembershipId(String value) {
            this.membershipId = value;
        }
        String membershipId ;
    }

    @Value
    public static class MembershipJWTToken {
        public MembershipJWTToken(String value) {
            this.jwtToken = value;
        }
        String jwtToken ;
    }
    @Value
    public static class MembershipRefreshToken {
        public MembershipRefreshToken(String value) {
            this.refreshToken = value;
        }
        String refreshToken;
    }
}
