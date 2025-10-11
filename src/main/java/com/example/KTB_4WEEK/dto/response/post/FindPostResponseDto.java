package com.example.KTB_4WEEK.dto.response.post;

import com.example.KTB_4WEEK.entity.PostCategory;
import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FindPostResponseDto {
    private long id = 0L;
    private long authorId = 0L;
    private String title = "";
    private String article = "";
    private String articleImage = "";
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
