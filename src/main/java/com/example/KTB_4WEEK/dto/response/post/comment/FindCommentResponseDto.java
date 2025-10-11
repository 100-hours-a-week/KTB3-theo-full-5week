package com.example.KTB_4WEEK.dto.response.post.comment;

import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FindCommentResponseDto {
    private long id;
    private long userId;
    private String content;
    private String created_at;
    private String updated_at;

    public FindCommentResponseDto(long id, long userId, String content,
                                  LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.created_at = created_at.format(DateTimeFormatter
                .ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        this.updated_at = updated_at.format(DateTimeFormatter
                .ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
