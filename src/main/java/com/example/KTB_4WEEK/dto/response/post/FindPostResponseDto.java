package com.example.KTB_4WEEK.dto.response.post;

import com.example.KTB_4WEEK.entity.PostCategory;
import com.example.KTB_4WEEK.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FindPostResponseDto {
    @Schema(description = "조회한 게시글 PK", example = "1")
    private long id = 0L;
    @Schema(description = "게시글 작성자 PK", example = "1")
    private long authorId = 0L;
    @Schema(description = "게시글 제목", example = "제목")
    private String title = "";
    @Schema(description = "게시글 본문", example = "게시글 본문 내용")
    private String article = "";
    @Schema(description = "게시글에 포함된 이미지 URL", example = "https://www.test.com")
    private String articleImage = "";
    @Schema(description = "게시글 카테고리(소통방, 고민상담, 정보공유)", example = "COMMUNITY, COUNSELING, INFO_SHARE")
    private PostCategory category = PostCategory.NONE;

    private int hit = 0;
    private int like = 0;
    private String createdAt = "";
    private String updatedAt = "";
    private boolean isDeleted = false;

    public FindPostResponseDto() {
    }

    public FindPostResponseDto(long id, long authorId, String title,
                               String article, String articleImage, PostCategory category,
                               int hit, int like, LocalDateTime createdAt,
                               LocalDateTime updatedAt, boolean isDeleted) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.article = article;
        this.articleImage = articleImage;
        this.category = category;
        this.hit = hit;
        this.like = like;
        this.createdAt = createdAt.format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        this.updatedAt = updatedAt.format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        this.isDeleted = isDeleted;
    }

    public long getId() {
        return id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getArticle() {
        return article;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public PostCategory getCategory() {
        return category;
    }

    public int getHit() {
        return hit;
    }

    public int getLike() {
        return like;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}
