package com.example.KTB_4WEEK.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class RequestDTO {
    @Schema(description = "이메일", example = "test@test.com")
    protected String email;

}
