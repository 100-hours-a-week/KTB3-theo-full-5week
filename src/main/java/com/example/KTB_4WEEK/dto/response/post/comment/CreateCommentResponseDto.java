package com.example.KTB_4WEEK.dto.response.post.comment;

public class CreateCommentResponseDto {
    private long id;
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
