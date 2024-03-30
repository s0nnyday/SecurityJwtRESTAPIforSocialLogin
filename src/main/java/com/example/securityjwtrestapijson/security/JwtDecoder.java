package com.example.securityjwtrestapijson.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // @Bean 주입할거기때문에 @RequiredArgsConstructor 어노테이션 사용
public class JwtDecoder {
    private final JwtProperties properties;
    public DecodedJWT decode(String token) {
         return JWT.require(Algorithm.HMAC256(properties.getSecretKey()))
                 .build()
                 .verify(token);
    }
}
