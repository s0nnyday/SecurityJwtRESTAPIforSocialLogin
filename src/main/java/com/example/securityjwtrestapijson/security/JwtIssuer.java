package com.example.securityjwtrestapijson.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtIssuer {
    private final JwtProperties properties;

    //TODO 로그인 시 JWT 반환 PAYLOAD 로 username, role, issueAt, expiration 네 가지 항목으로 바꾸기
    public String issue(long userId, String email, List<String> roles) {
        Date issuedAt = new Date();
        Date expiresAt = new Date(System.currentTimeMillis() + Duration.ofDays(1).toMillis());

        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
//                .withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS))) // 보통 duration 짧게 하는데 튜토리얼이니까 1day
                .withClaim("email", email)
                .withClaim("role", roles)
                .sign(Algorithm.HMAC256(properties.getSecretKey()));
    }
}
