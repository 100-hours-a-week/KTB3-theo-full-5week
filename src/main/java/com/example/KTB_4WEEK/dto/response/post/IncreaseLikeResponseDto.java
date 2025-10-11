package com.example.KTB_4WEEK.dto.response.post;

import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IncreaseLikeResponseDto {
    private long id;
    private int like;
    private String updateAt;

    public IncreaseLikeResponseDto(long id, int like, LocalDateTime updateAt) {
        this.id = id;
        this.like = like;
        this.updateAt = updateAt.format(DateTimeFormatter
                .ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
    }

    public long getId() {
        return id;
    }

    public int getLike() {
        return like;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }
}
