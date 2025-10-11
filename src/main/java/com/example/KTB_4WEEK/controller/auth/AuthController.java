package com.example.KTB_4WEEK.controller.auth;

import com.example.KTB_4WEEK.dto.request.user.LoginRequestDto;
import com.example.KTB_4WEEK.dto.response.common.BaseResponse;
import com.example.KTB_4WEEK.dto.response.user.LoginResponseDto;
import com.example.KTB_4WEEK.service.auth.TokenService;
import com.example.KTB_4WEEK.service.user.PublicUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final PublicUserService publicUserService;
    private final TokenService tokenService;
    private final int tokenExpireMin = 10;

    public AuthController(PublicUserService publicUserService, TokenService tokenService) {
        this.publicUserService = publicUserService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login") // 로그인
    public ResponseEntity<BaseResponse> login(@RequestBody LoginRequestDto request) {
        BaseResponse response = publicUserService.login(request);
        String token = tokenService.issue(((LoginResponseDto) response.getData()).getId(),
                Duration.ofMinutes(tokenExpireMin));

        return ResponseEntity.status(HttpStatus.OK)
                .header("Authorization", "Bearer" + token)
                .body(response);
    }

}
