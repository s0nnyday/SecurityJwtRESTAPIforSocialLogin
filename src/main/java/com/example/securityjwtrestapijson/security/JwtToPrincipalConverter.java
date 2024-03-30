package com.example.securityjwtrestapijson.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtToPrincipalConverter {
    public CustomUserDetails convert(DecodedJWT jwt) {
        return CustomUserDetails.builder()
                .userId(Long.valueOf(jwt.getSubject()))
                .email(jwt.getClaim("e").asString())
                .authorities(extractAuthoritiesFromClaim(jwt))
                .build();
    }

    private List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT jwt) {
        var claim = jwt.getClaim("a");
        if (claim.isNull() || claim.isMissing()) return List.of(); // 빈 권한 목록 반환
        return claim.asList(SimpleGrantedAuthority.class); // 클레임 존재하면 해당 클레임을 SimpleGrantedAuthority 객체의 목록으로 반환
    }
}
