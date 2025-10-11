package com.example.KTB_4WEEK.dto.response.post;

import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IncreaseHitResponseDto {
    private long id;
    private int hit;
    private String updateAt;

    public IncreaseHitResponseDto(long id, int hit, LocalDateTime updateAt) {
        this.id = id;
        this.hit = hit;
        this.updateAt = updateAt.format(DateTimeFormatter
                .ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
    }

    public long getId() {
        return id;
    }

    public int getHit() {
        return hit;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }
}
