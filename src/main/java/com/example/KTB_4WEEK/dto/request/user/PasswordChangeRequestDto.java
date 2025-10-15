package com.example.KTB_4WEEK.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class PasswordChangeRequestDto {
    @Schema(description = "변경 요청 비밀번호", example = "1q2w3e4r!Q!Q")
    private String password;

    public PasswordChangeRequestDto() {}

    public String getPassword() {
        return password;
    }
}
