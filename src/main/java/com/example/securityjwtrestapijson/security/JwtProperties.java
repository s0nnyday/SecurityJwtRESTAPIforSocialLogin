package com.example.securityjwtrestapijson.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.jwt")
public class JwtProperties {
    /**
     * Secret key used for issuing JWT
     */
    private String secretKey;
    private String password;
}
