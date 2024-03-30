package com.example.securityjwtrestapijson.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginErrorResponse {
    private final int status;
    private final boolean success;
    private final String message;
    private final String error;
}
