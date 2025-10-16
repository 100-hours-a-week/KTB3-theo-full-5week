package com.example.KTB_5WEEK.dto.request.post;

import com.example.KTB_5WEEK.entity.PostCategory;
import io.swagger.v3.oas.annotations.media.Schema;

public class CreatePostRequestDto {
    @Schema(description = "게시글 작성 유저 PK", example = "1")
    private long authorId;
    @Schema(description = "게시글 제목", example = "제목")
    private String title;
    @Schema(description = "게시글 본문", example = "게시글 본문 내용")
    private String article;
    @Schema(description = "게시글 본문 내 삽입할 이미지 URL", example = "https://www.test.com")
    private String articleImage;
    @Schema(description = "게시글의 카테고리(소통방, 고민상담, 정보공유)", example = "COMMUNITY, COUNSELING, INFO_SHARE")
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
