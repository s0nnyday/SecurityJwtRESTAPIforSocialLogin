package com.example.securityjwtrestapijson.response.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    FILE_CONVERT_FAIL(500, "변환할 수 없는 파일입니다."),
    NON_EXISTENT_EMAIL(500, "변환할 수 없는 파일입니다.");
    private final int code;
    private final String message;
}
