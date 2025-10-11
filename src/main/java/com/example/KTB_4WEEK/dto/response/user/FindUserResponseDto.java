package com.example.KTB_4WEEK.dto.response.user;

import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FindUserResponseDto {
    private long id;
    private String email;
    private String nickname;
    private String profile_image;
    private String created_at;
    private String updated_at;

    public FindUserResponseDto(long id, String email, String nickname,
                               String profile_image, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.profile_image = profile_image;
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

    public String getProfile_image() {
        return profile_image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
