package com.example.KTB_5WEEK.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class RegistUserRequestDto {
    @Schema(description = "회원가입시 사용할 이메일", example = "test@test.com")
    private String email;
    @Schema(description = "회원가입시 사용할 비밀번호", example = "1q2w3e4r!Q")
    private String password;
    @Schema(description = "회원가입시 사용할 닉네임", example = "nickname")
    private String nickname;
    @Schema(description = "회원가입시 사용할 프로필 이미지 URL", example = "https://www.test.com")
    private String profileImage;

    public RegistUserRequestDto() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfileImage() {
        return profileImage;
    }

}
