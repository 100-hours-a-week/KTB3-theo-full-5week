package com.example.KTB_5WEEK.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class CheckNicknameAvailabilityResponseDto {
    @Schema(description = "중복 검사 대상 닉네임", example = "nickname")
    private String nickname;
    @Schema(description = "닉네임 사용가능 여부", example = "true/false")
    private boolean isAvailable;

    public CheckNicknameAvailabilityResponseDto(String nickname, boolean isAvailable) {
        this.nickname = nickname;
        this.isAvailable = isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
