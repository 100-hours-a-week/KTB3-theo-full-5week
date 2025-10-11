package com.example.KTB_4WEEK.dto.response.post.comment;

import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateCommentResponseDto {
    private long id;
    private long postId;
    private long userId;
    private String content;
    private String createAt;
    private String updateAt;

    public UpdateCommentResponseDto(long id, long postId, long userId, String content,
                                    LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.createAt = createAt.format(DateTimeFormatter
                .ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        this.updateAt = updateAt.format(DateTimeFormatter
                .ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
    }

    public long getId() {
        return id;
    }

    public long getPostId() {
        return postId;
    }

    public long getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }
}
