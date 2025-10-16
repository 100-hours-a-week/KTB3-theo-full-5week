package com.example.KTB_4WEEK.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class CheckEmailAvailabilityRequestDto {
    private String email;

    public CheckEmailAvailabilityRequestDto() {
    }

    public String getEmail() {
        return email;
    }

}
