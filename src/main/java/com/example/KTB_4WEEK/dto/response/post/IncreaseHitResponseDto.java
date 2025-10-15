package com.example.KTB_4WEEK.dto.response.post;

import com.example.KTB_4WEEK.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IncreaseHitResponseDto {
    @Schema(description = "조회 수 증가된 게시물 PK", example = "1")
    private long id;
    @Schema(description = "게시물의 총 조회 수", example = "20")
    private int hit;
    @Schema(description = "게시물의 최근 업데이트 시간", example = "2025-10-10 20:00:00")
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
