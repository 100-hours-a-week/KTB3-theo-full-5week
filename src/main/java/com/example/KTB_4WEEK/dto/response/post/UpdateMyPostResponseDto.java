package com.example.KTB_4WEEK.dto.response.post;

import com.example.KTB_4WEEK.entity.PostCategory;
import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateMyPostResponseDto {
    private long id;
    private String title;
    private String article;
    private String articleImage;
    private PostCategory category;
    private String updateAt;

    public UpdateMyPostResponseDto(long id, String title, String article,
                                   String articleImage, PostCategory category,
                                   LocalDateTime updateAt) {
        this.id = id;
        this.title = title;
        this.article = article;
        this.articleImage = articleImage;
        this.category = category;
        this.updateAt = updateAt.format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
    }

    public long getId() {
        return id;
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

    public String getUpdateAt() {
        return updateAt;
    }
}
