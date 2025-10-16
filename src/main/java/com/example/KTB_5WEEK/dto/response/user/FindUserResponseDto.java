package com.example.KTB_5WEEK.dto.response.user;

import com.example.KTB_5WEEK.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FindUserResponseDto {
    @Schema(description = "조회된 유저 PK", example = "1")
    private long id;
    @Schema(description = "유저 이메일", example = "test@test.com")
    private String email;
    @Schema(description = "유저 닉네임", example = "닉네임")
    private String nickname;
    @Schema(description = "유저 프로필 이미지 URL", example = "https://www.test.com")
    private String profileImage;
    @Schema(description = "유저 생성 시간", example = "2025-10-10 20:00:00")
    private String created_at;
    @Schema(description = "최근 유저 업데이트 시간", example = "2025-10-10 20:00:00")
    private String updated_at;

    public FindUserResponseDto(long id, String email, String nickname,
                               String profileImage, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.created_at = created_at.format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        this.updated_at = updated_at.format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
