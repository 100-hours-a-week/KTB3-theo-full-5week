package com.example.KTB_4WEEK.dto.request.post.comment;

public class CreateCommentRequestDto {
    private long userId;
    private String content;

    public CreateCommentRequestDto() {}

    public long getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }
}
