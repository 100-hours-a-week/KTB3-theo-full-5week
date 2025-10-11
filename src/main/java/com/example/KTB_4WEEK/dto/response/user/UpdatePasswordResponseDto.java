package com.example.KTB_4WEEK.dto.response.user;

import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdatePasswordResponseDto {
    private long id;
    private String password;
    private String updatedAt;

    public UpdatePasswordResponseDto(long id, String password) {
        this.id = id;
        this.password = password;
        this.updatedAt = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));

    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
