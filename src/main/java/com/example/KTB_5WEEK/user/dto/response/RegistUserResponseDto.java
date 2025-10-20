package com.example.KTB_5WEEK.user.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;

public class RegistUserResponseDto {
    @Schema(description = "생성된 유저 PK", example = "1")
    private long id = 0L;

    public RegistUserResponseDto(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id : " + this.id;
    }

    public long getId() {
        return id;
    }
}
