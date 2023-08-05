package com.fastcampuspay.membership.adapter.out.jwt;

import com.fastcampuspay.membership.application.port.out.AuthMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;


// 실제로 jwt token 생성 로직 전부를 가지고 있을거에요
@Component
public class JwtTokenProvider implements AuthMembershipPort {

    private String jwtSecret; // 내부 비밀키. 즉, jwt token 생성을 위한 비밀키에요.

    private long jwtTokenExpirationInMs; // jwt token 의 만료시간. 즉, jwt token 의 유효시간에요.

    private long refreshTokenExpirationInMs; // refresh token 의 만료시간. 즉, refresh token 의 유효시간에요.

    public JwtTokenProvider() {
        // 512bit 알고리즘 지원을 위한 비밀키 입니다.
        // 512 bit = 64 byte
        // env 등을 통해서, 외부 환경변수로부터 데이터를 받아올 수도 있어요.
        this.jwtSecret = "NYd4nEtyLtcU7cpS/1HTFVmQJd7MmrP+HafWoXZjWNOL7qKccOOUfQNEx5yvG6dfdpuBeyMs9eEbRmdBrPQCNg==";
        this.jwtTokenExpirationInMs = 1000L * 20; // 20초
        this.refreshTokenExpirationInMs = 1000L * 60; // 60초
    }

    @Override
    public String generateJwtToken(Membership.MembershipId membershipId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtTokenExpirationInMs);

        return Jwts.builder()
                .setSubject(membershipId.getMembershipId())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    @Override
    public String generateRefreshToken(Membership.MembershipId membershipId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + refreshTokenExpirationInMs);

        return Jwts.builder()
                .setSubject(membershipId.getMembershipId())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    @Override
    public boolean validateJwtToken(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken);
            return true;
        } catch (MalformedJwtException ex) {
            // Invalid JWT token: 유효하지 않은 JWT 토큰일 때 발생하는 예외
        } catch (ExpiredJwtException ex) {
            // Expired JWT token: 토큰의 유효기간이 만료된 경우 발생하는 예외
        } catch (UnsupportedJwtException ex) {
            // Unsupported JWT token: 지원하지 않는 JWT 토큰일 때 발생하는 예외
        } catch (IllegalArgumentException ex) {
            // JWT claims string is empty: JWT 토큰이 비어있을 때 발생하는 예외
        }
        return false;
    }

    @Override
    public Membership.MembershipId parseMembershipIdFromToken(String jwtToken) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody();
        return new Membership.MembershipId(claims.getSubject());
    }
}
