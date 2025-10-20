package com.example.KTB_5WEEK.post.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class CreatePostResponseDto {
    @Schema(description = "생성된 게시글의 PK", example = "1")
    private long id;

    public CreatePostResponseDto(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
