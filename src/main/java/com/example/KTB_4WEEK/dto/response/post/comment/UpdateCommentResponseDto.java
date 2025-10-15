package com.example.KTB_4WEEK.dto.response.post.comment;

import com.example.KTB_4WEEK.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateCommentResponseDto {
    @Schema(description = "수정 완료한 댓글의 pK", example = "1")
    private long id;
    @Schema(description = "수정 완료한 댓글을 가지는 게시글 PK", example = "1")
    private long postId;
    @Schema(description = "댓글 작성자 PK", example = "1")
    private long userId;
    @Schema(description = "수정 완료한 댓글 내용", example = "댓글 내용")
    private String content;
    @Schema(description = "댓글의 생성 시간", example = "2025-10-10 20:00:00")
    private String createAt;
    @Schema(description = "댓글의 최신 업데이트 시간", example = "2025-10-10 20:00:00")
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
