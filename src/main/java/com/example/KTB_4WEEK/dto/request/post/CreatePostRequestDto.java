package com.example.KTB_4WEEK.dto.request.post;

import com.example.KTB_4WEEK.entity.PostCategory;

public class CreatePostRequestDto {
    private long authorId;
    private String title;
    private String article;
    private String articleImage;
    private PostCategory category;

    public CreatePostRequestDto() {};

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

    @Override
    public String toString() {
        return "authorId : " + authorId
                + " / title : " + title
                + " / article : " + article
                + " / articleImage : " + articleImage
                + " / category : " + category;
    }
}
