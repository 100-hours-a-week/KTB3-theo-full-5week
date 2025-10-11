package com.example.KTB_4WEEK.dto.response.user;

public class CheckNicknameAvailabilityResponseDto {
    private String nickname;
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
