package com.example.KTB_5WEEK.dto.response.post.comment;

import com.example.KTB_5WEEK.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FindCommentResponseDto {
    @Schema(description = "조회한 댓글의 PK", example = "1")
    private long id;
    @Schema(description = "조회한 댓글의 작성자(유저) PK", example = "1")
    private long userId;
    @Schema(description = "조회한 댓글의 내용", example = "댓글 내용")
    private String content;
    @Schema(description = "조회한 댓글의 생성 시간", example = "2025-10-16 20:00:00")
    private String created_at;
    @Schema(description = "조회한 댓글의 최근 업데이트 시간", example = "2025-10-16 20:00:00")
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
