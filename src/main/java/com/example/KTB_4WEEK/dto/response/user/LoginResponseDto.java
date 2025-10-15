package com.example.KTB_4WEEK.dto.response.user;


import io.swagger.v3.oas.annotations.media.Schema;

public class LoginResponseDto {
    @Schema(description = "로그인 유저 PK", example = "1")
    private long id = 0L;
    @Schema(description = "로그인 성공 여부", example = "true/false")
    private boolean isLoginSuccess = false;

    public LoginResponseDto(long id, boolean isLogin) {
        this.id = id;
        this.isLoginSuccess = isLogin;
    }

    public long getId() {
        return id;
    }

    public boolean isLoginSuccess() {
        return isLoginSuccess;
    }
}
