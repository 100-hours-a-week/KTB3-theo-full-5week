package com.example.KTB_4WEEK.dto.response.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class CheckEmailAvailabilityResponseDto {
    @Schema(description = "중복 검사 대상 이메일", example = "test@test.com")
    private String email;
    @Schema(description = "이메일 사용가능 여부", example = "true/false")
    private boolean isAvailable;

    public CheckEmailAvailabilityResponseDto(String email, boolean isAvailable) {
        this.email = email;
        this.isAvailable = isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
