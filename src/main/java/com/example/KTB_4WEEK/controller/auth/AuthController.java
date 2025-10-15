package com.example.KTB_4WEEK.controller.auth;

import com.example.KTB_4WEEK.dto.request.user.LoginRequestDto;
import com.example.KTB_4WEEK.dto.response.common.BaseResponse;
import com.example.KTB_4WEEK.dto.response.user.LoginResponseDto;
import com.example.KTB_4WEEK.service.auth.TokenService;
import com.example.KTB_4WEEK.service.user.PublicUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "로그인", description = "이메일과 비밀번호를 통해 사용자를 인증합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "404", description = "로그인 실패. 유저를 찾을 수 없습니다.")
    })
    @PostMapping("/login") // 로그인
    public ResponseEntity<BaseResponse> login(
            @Parameter(description = "로그인 요청 DTO, 이메일, 비빌번호를 포함합니다.",
                    required = true,
                    examples = {@ExampleObject(name = "email", value = "test@test.com"),
                            @ExampleObject(name = "password", value = "1q2w3e4r!Q")
                    })
            @RequestBody LoginRequestDto request) {
        BaseResponse response = publicUserService.login(request);
        String token = tokenService.issue(((LoginResponseDto) response.getData()).getId(),
                Duration.ofMinutes(tokenExpireMin));

        return ResponseEntity.status(HttpStatus.OK)
                .header("Authorization", "Bearer" + token)
                .body(response);
    }

}
