package com.example.securityjwtrestapijson.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String provider;
    private String providerId;
    private String email;
//    private String password; 가짜 비밀번호로 대체
}
