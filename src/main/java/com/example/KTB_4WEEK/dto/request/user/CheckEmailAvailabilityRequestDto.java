package com.example.KTB_4WEEK.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class CheckEmailAvailabilityRequestDto {
    @Schema(description = "중복 검사 대상 이메일", example = "test@test.com")
    private String email;

    public CheckEmailAvailabilityRequestDto() {
    }

    public String getEmail() {
        return email;
    }
}
