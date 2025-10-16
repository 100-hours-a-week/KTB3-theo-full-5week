package com.example.KTB_5WEEK.dto.response.post;

import com.example.KTB_5WEEK.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IncreaseLikeResponseDto {
    @Schema(description = "좋아요 수 증가 대상 게시물 PK", example = "1")
    private long id;
    @Schema(description = "게시물의 총 좋아요 개수", example = "100")
    private long like;
    @Schema(description = "게시물 최근 업데이트 시간", example = "2025-10-10 20:00:00")
    private String updateAt;

    public IncreaseLikeResponseDto(long id, long like, LocalDateTime updateAt) {
        this.id = id;
        this.like = like;
        this.updateAt = updateAt.format(DateTimeFormatter
                .ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
    }

    public long getId() {
        return id;
    }

    public long getLike() {
        return like;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }
}
