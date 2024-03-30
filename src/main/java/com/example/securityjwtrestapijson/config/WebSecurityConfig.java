package com.example.securityjwtrestapijson.config;

import com.example.securityjwtrestapijson.security.CustomUserDetailService;
import com.example.securityjwtrestapijson.security.JwtAuthenticationFilter;
import com.example.securityjwtrestapijson.security.UnauthorizedHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomUserDetailService customUserDetailService;
    private final UnauthorizedHandler unauthorizedHandler;

    @Bean
    public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .securityMatcher("/**") // map current config to given resource path
                .sessionManagement(sessionManagementConfigurer
                        -> sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 세션 관리 정책 설정 - 상태를 유지하지 않는 세션
                .formLogin(AbstractHttpConfigurer::disable)
                    .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                .authorizeHttpRequests(registry -> registry // 요청에 대한 권한 설정 메서드
                        .requestMatchers("/", "/auth/**", "/v1/wc/**").permitAll() // / 경로 요청에 대한 권한을 설정. permitAll() 모든 사용자, 인증되지않은 사용자에게 허용
                        .requestMatchers("/admin/**").hasRole("ADMIN") // ROLE_ADMIN 에게만 허용
                        .anyRequest().authenticated() // 다른 나머지 모든 요청에 대한 권한 설정, authenticated()는 인증된 사용자에게만 허용, 로그인해야만 접근 가능
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder())
                .and().build();
    }
}