package com.example.securityjwtrestapijson.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiResponseMessage {
    //유저 회원가입 및 로그인
    SIGNUP_SUCCESS("회원가입에 성공하였습니다."),
    LOGIN_SUCCESS("로그인에 성공하였습니다."),
    //웹 크롤러
    WEBCRAWLING_NIKE_SUCCESS("나이키 데이터 로드에 성공하였습니다."),
    WEBCRAWLING_KASINA_SUCCESS("카시나 데이터 로드에 성공하였습니다.");

    private final String message;
}
