package com.example.KTB_4WEEK.dto.response.user;

import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateNicknameResponseDto {
    private long id;
    private String nickname;
    private String createdAt;
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
