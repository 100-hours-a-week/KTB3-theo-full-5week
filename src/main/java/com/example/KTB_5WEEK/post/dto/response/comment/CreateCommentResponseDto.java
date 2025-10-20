package com.example.KTB_5WEEK.post.dto.response.comment;

import io.swagger.v3.oas.annotations.media.Schema;

public class CreateCommentResponseDto {
    @Schema(description = "생성된 댓글의 PK", example = "1")
    private long id;
    @Schema(description = "생성된 댓글 내용", example = "댓글 내용")
    private String content;

    public CreateCommentResponseDto(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
