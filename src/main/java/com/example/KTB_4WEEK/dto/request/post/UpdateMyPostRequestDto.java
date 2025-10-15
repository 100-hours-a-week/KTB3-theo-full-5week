package com.example.KTB_4WEEK.dto.request.post;

import com.example.KTB_4WEEK.entity.PostCategory;
import io.swagger.v3.oas.annotations.media.Schema;

public class UpdateMyPostRequestDto {
    @Schema(description = "수정 요청할 게시글 제목", example = "수정된 재목")
    private String title;
    @Schema(description = "수정 요청할 게시글 본문", example = "수정된 게시글 본문")
    private String article;
    @Schema(description = "기존 게시글 본문 이미지 교체", example = "https://www.NewImage.com")
    private String articleImage;
    @Schema(description = "수정할 게시글 카테고리(소통방, 고민상담, 정보공유)", example = "COMMUNITY, COUNSELING, INFO_SHARE")
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
