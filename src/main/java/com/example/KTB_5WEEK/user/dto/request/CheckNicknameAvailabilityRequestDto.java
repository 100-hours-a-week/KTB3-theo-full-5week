package com.example.KTB_5WEEK.user.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;

public class CheckNicknameAvailabilityRequestDto {
    @Schema(description = "중복 검사 대상 닉네임", example = "nickname")
    private String nickname;

    public CheckNicknameAvailabilityRequestDto() {}

    public String getNickname() {
        return nickname;
    }

}
