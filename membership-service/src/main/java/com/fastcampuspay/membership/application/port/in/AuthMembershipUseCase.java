package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.membership.domain.JWTToken;
import com.fastcampuspay.membership.domain.Membership;

import java.util.List;

public interface AuthMembershipUseCase {
	JWTToken login(LoginCommand command);

	JWTToken refreshToken(RefreshTokenCommand command);

	boolean validateToken(ValidateTokenCommand command);
}
