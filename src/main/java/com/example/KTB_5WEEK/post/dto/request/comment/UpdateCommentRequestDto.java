package com.example.KTB_5WEEK.post.dto.request.comment;

import io.swagger.v3.oas.annotations.media.Schema;

public class UpdateCommentRequestDto {
    @Schema(description = "댓글 수정본", example = "수정한 댓글 내용")
    private String content;

    public UpdateCommentRequestDto() {
    }

    public String getContent() {
        return content;
    }
}
