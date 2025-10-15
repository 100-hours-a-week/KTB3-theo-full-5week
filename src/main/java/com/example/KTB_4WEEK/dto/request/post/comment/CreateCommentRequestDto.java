package com.example.KTB_4WEEK.dto.request.post.comment;

import io.swagger.v3.oas.annotations.media.Schema;

public class CreateCommentRequestDto {
    @Schema(description = "User PK", example = "1")
    private long userId;
    @Schema(description = "댓글 내용", example = "댓글 내용")
    private String content;

    public CreateCommentRequestDto() {}

    public long getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }
}
