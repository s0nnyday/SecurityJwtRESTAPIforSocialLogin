package com.example.securityjwtrestapijson.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Builder
public class CustomUserDetails implements UserDetails {
    private final Long userId;
    private final String email;
    @JsonIgnore
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    // 사용자에게 부여된 권한 목록을 반환한다.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // 사용자의 비밀번호를 반환한다.
    @Override
    public String getPassword() {
        return password;
    }

    // 사용자의 이름(아이디)를 반환한다.
    @Override
    public String getUsername() {
        return email;
    }

    // 계정이 만료되지 않았는지?
    @Override
    public boolean isAccountNonExpired() {
        return true; // true: 만료되자 않았다.
    }
    // 계정이 잠겨있지 않은지?
    @Override
    public boolean isAccountNonLocked() {
        return true; // true: 잠겨있지 않다.
    }

    // 자격 증명이 만료되지 않았는지?
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 만료되지 않았다.
    }

    // 활성화되어 있는지?
    @Override
    public boolean isEnabled() {
        return true; // 활성화 되어있다
    }
}
