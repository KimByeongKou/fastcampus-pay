package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.application.port.in.AuthMembershipUseCase;
import com.fastcampuspay.membership.application.port.in.LoginCommand;
import com.fastcampuspay.membership.application.port.in.RefreshTokenCommand;
import com.fastcampuspay.membership.application.port.in.ValidateTokenCommand;
import com.fastcampuspay.membership.application.port.out.AuthMembershipPort;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.membership.domain.JWTToken;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class AuthMembershipService implements AuthMembershipUseCase {

    private final AuthMembershipPort authMembershipPort;

    private final FindMembershipPort findMembershipPort;

    private final ModifyMembershipPort modifyMembershipPort;

    @Override
    public JWTToken login(LoginCommand command) {
        String membershipId = command.getMembershipId();
        MembershipJpaEntity jpaEntity = findMembershipPort.findMembership(new Membership.MembershipId(membershipId));

        if (jpaEntity.isValid()){
            String jwtToken = authMembershipPort.generateJWTToken(new Membership.MembershipId(membershipId));
            String refreshToken = authMembershipPort.generateRefreshToken(new Membership.MembershipId(membershipId));
            modifyMembershipPort.modifyMembership(
                    new Membership.MembershipId(membershipId),
                    new Membership.MembershipName(jpaEntity.getName()),
                    new Membership.MembershipEmail(jpaEntity.getEmail()),
                    new Membership.MembershipAddress(jpaEntity.getAddress()),
                    new Membership.MembershipIsValid(jpaEntity.isValid()),
                    new Membership.MembershipIsCorp(jpaEntity.isCorp()),
                    new Membership.MembershipRefreshToken(refreshToken)
            );
            return JWTToken.generateJWTToken(
                    new JWTToken.MembershipId(membershipId),
                    new JWTToken.MembershipJWTToken(jwtToken),
                    new JWTToken.MembershipRefreshToken(refreshToken)
            );
        }

        return null;
    }

    @Override
    public JWTToken refreshToken(RefreshTokenCommand command) {
        boolean isValidToken = authMembershipPort.validateJWTToken(command.getRefreshToken());
        if (isValidToken) {
            MembershipJpaEntity jpaEntity = findMembershipPort.findMembership(authMembershipPort.parseMembershipIdFromToken(command.getRefreshToken()));
            if (!command.getRefreshToken().equals(jpaEntity.getRefreshToken())) {
                // refresh token not equal err
                return null;
            }

            if (jpaEntity.isValid()){
                String newJwtToken = authMembershipPort.generateJWTToken(new Membership.MembershipId(""+jpaEntity.getMembershipId()));
                return JWTToken.generateJWTToken(
                        new JWTToken.MembershipId(""+jpaEntity.getMembershipId()),
                        new JWTToken.MembershipJWTToken(newJwtToken),
                        new JWTToken.MembershipRefreshToken(command.getRefreshToken())
                );
            }
        }

        return null;
    }

    @Override
    public boolean validateToken(ValidateTokenCommand command) {
        return authMembershipPort.validateJWTToken(command.getJwtToken());
    }
}