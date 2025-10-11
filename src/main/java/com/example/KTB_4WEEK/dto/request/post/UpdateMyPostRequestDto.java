package com.example.KTB_4WEEK.dto.request.post;

import com.example.KTB_4WEEK.entity.PostCategory;

public class UpdateMyPostRequestDto {
    private String title;
    private String article;
    private String articleImage;
    private PostCategory category;

    public UpdateMyPostRequestDto() {};

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


}
