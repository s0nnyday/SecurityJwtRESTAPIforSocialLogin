package com.example.securityjwtrestapijson.controller;

import com.example.securityjwtrestapijson.dto.LoginRequest;
import com.example.securityjwtrestapijson.dto.RegisterRequest;
import com.example.securityjwtrestapijson.response.ApiResponse;
import com.example.securityjwtrestapijson.response.error.ErrorCode;
import com.example.securityjwtrestapijson.security.JwtProperties;
import com.example.securityjwtrestapijson.service.AuthService;
import com.example.securityjwtrestapijson.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtProperties properties;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody @Validated LoginRequest request){

//        String token = authService.attemptLogin(request.getProvider(), request.getProviderId(), request.getEmail(), request.getPassword());
        String token = authService.attemptLogin(request.getProvider(), request.getProviderId(), request.getEmail(), properties.getPassword());

        if (token.startsWith("[ERROR]")) {
            return ApiResponse.failure(ErrorCode.NON_EXISTENT_EMAIL);
        }
        return ApiResponse.ok(token);
    }

    @PostMapping("/registerUser")
    public ApiResponse register(@RequestBody @Validated RegisterRequest request) {
        //회원 가입 하고 성공 여부만 or jwt 반환하여 로그인까지?
        authService.registerUser(request);

        //일단 메세지만 반환 나중에 jwt 반환으로 변경?
        return ApiResponse.ok(Constants.SUCCESSFUL_REGISTRATION);

//        return authService.registerUser(request);
    }
}
