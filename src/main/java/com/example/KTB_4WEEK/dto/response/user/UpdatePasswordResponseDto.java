package com.example.KTB_4WEEK.dto.response.user;

import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdatePasswordResponseDto {
    private long id;
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
