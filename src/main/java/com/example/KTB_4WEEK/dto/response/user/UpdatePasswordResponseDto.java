package com.example.KTB_4WEEK.dto.response.user;

import com.example.KTB_4WEEK.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdatePasswordResponseDto {
    @Schema(description = "비밀번호 변경한 유저의 PK", example = "1")
    private long id;
    @Schema(description = "최근 유저 업데이트 시간", example = "2025-10-10 20:00:00")
    private String updatedAt;

    public UpdatePasswordResponseDto(long id) {
        this.id = id;
        this.updatedAt = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));

    }

    public long getId() {
        return id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
