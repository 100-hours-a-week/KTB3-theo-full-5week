package com.example.KTB_4WEEK.dto.response.user;


public class LoginResponseDto {
    private long id = 0L;
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
