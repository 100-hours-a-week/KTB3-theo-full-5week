package com.example.KTB_5WEEK.auth.controller;

import com.example.KTB_5WEEK.auth.service.AuthService;
import com.example.KTB_5WEEK.swagger.controller.AuthApiDoc;
import com.example.KTB_5WEEK.user.dto.request.LoginRequestDto;
import com.example.KTB_5WEEK.app.response.BaseResponse;
import com.example.KTB_5WEEK.user.dto.response.LoginResponseDto;
import com.example.KTB_5WEEK.auth.service.TokenService;
import com.example.KTB_5WEEK.user.service.PublicUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/auth")
public class AuthController implements AuthApiDoc {
    private final AuthService authService;
    private final TokenService tokenService;
    private final int tokenExpireMin = 10;

    public AuthController(AuthService authService, TokenService tokenService) {
        this.authService = authService;
        this.tokenService = tokenService;
    }

    @PostMapping("/access/token") // 로그인
    public ResponseEntity<BaseResponse> login(@RequestBody LoginRequestDto request) {
        BaseResponse response = authService.login(request);
        String token = tokenService.issue(((LoginResponseDto) response.getData()).getId(),
                Duration.ofMinutes(tokenExpireMin));

        return ResponseEntity.status(HttpStatus.OK)
                .header("Authorization", "Bearer" + token)
                .body(response);
    }

    @PostMapping("/logout") // 로그아웃
    public ResponseEntity<BaseResponse> logout(HttpServletRequest request) {
        BaseResponse response = authService.logout();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

}
