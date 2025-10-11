package com.example.KTB_4WEEK.dto.response.post;

public class CreatePostResponseDto {
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
