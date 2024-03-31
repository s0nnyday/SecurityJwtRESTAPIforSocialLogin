package com.example.securityjwtrestapijson.util;

public class Constants {
    //TODO 삭제해야한다.
    // 회원 가입 시 메세지
    public static final String EMAIL_ALREADY_EXISTS = "이미 사용 중인 이메일"; //52001
    public static final String SUCCESSFUL_REGISTRATION = "회원 가입 성공"; //0
    public static final String INVALID_EMAIL_FORMAT = "유효하지 않은 이메일 형식"; //5203
    public static final String INVALID_PASSWORD_FORMAT = "유효하지 않은 비밀번호 형식"; //5400
    public static final String REGISTRATION_ERROR_MESSAGE = "회원 가입 중 오류가 발생했습니다. 나중에 다시 시도해주세요."; //5207

    // 로그인 시 메세지
    public static final String LOGIN_SUCCESS_MESSAGE = "로그인 성공"; //0
    public static final String LOGIN_ERROR_MESSAGE = "[ERROR]로그인 실패"; //55000
    public static final String INVALID_USERNAME_OR_PASSWORD_MESSAGE = "[ERROR]잘못된 아이디 또는 비밀번호"; //5600
    public static final String NON_EXISTENT_EMAIL = "[ERROR]존재하지 않는 이메일"; //5202
}

