package com.example.KTB_4WEEK.dto.response.user;

import com.example.KTB_4WEEK.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateNicknameResponseDto {
    @Schema(description = "닉네임 수정한 유저 PK", example = "1")
    private long id;
    @Schema(description = "변경된 닉네임", example = "nickname")
    private String nickname;
    @Schema(description = "유저 생성 시간", example = "2025-10-10 20:00:00")
    private String createdAt;
    @Schema(description = "최근 유저 업데이트 시간", example = "2025-10-10 20:00:00")
    private String updatedAt;

    public UpdateNicknameResponseDto(long id, String nickname, LocalDateTime createdAt) {
        this.id = id;
        this.nickname = nickname;
        this.createdAt = createdAt.format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        this.updatedAt = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));

    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
