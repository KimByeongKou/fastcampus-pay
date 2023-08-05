package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.membership.application.port.in.*;
import com.fastcampuspay.membership.domain.JWTToken;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class AuthMembershipController {

    private final AuthMembershipUseCase authMembershipUseCase;
    @PostMapping(path = "/membership/login")
    JWTToken loginMembership(@RequestBody LoginMembershipRequest request) {

        LoginCommand command = LoginCommand.builder()
                .membershipId(request.getMembershipId())
                .build();

        return authMembershipUseCase.login(command);
    }

    @PostMapping(path = "/membership/refresh-token")
    JWTToken refreshToken(@RequestBody RefreshTokenRequest request) {

        RefreshTokenCommand command = RefreshTokenCommand.builder()
                .refreshToken(request.getRefreshToken())
                .build();

        return authMembershipUseCase.refreshToken(command);
    }

    @PostMapping(path = "/membership/validate-token")
    boolean validateToken(@RequestBody ValidateTokenRequest request) {

        ValidateTokenCommand command = ValidateTokenCommand.builder()
                .jwtToken(request.getJwtToken())
                .build();

        return authMembershipUseCase.validateToken(command);
    }
}

