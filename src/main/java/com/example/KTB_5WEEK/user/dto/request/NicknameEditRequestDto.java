package com.example.KTB_5WEEK.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class NicknameEditRequestDto {
    @Schema(description = "변경할 닉네임", example = "Changed Nickname")
    private String nickname;

    public NicknameEditRequestDto() {

    }

    public String getNickname() {
        return this.nickname;
    }

}
