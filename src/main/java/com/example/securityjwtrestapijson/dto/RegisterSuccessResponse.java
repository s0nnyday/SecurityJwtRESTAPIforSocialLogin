package com.example.securityjwtrestapijson.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterSuccessResponse {
    private final int status;
    private final boolean success;
    private final String message;
    private final UserResponse user;

    @Getter
    @Builder
    public static class UserResponse {
        private final Long userId;
        private final String email;
        private final String role;
    }
}
