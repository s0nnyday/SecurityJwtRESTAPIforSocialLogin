package com.example.securityjwtrestapijson.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterErrorResponse {
    private final int status;
    private final boolean success;
    private final String message;

    // 추가적인 필드를 필요에 따라 정의할 수 있습니다.

    // 예를 들어, 에러 상세 정보를 담는 필드를 추가할 수 있습니다.
    // private final String errorDetails;
}
