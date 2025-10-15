package com.example.KTB_4WEEK.dto.response.post;

import com.example.KTB_4WEEK.entity.PostCategory;
import com.example.KTB_4WEEK.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateMyPostResponseDto {
    @Schema(description = "업데이트 완료한 게시글 PK", example = "1")
    private long id;
    @Schema(description = "게시글 제목", example = "제목")
    private String title;
    @Schema(description = "게시글 본문 내용", example = "내용")
    private String article;
    @Schema(description = "게시글 본문 이미지 URL", example = "https://www.test.com")
    private String articleImage;
    @Schema(description = "게시글 종류(소통방, 고민상담, 정보공유)", example = "COMMUNITY, COUNSELING, INFO_SHARE")
    private PostCategory category;
    @Schema(description = "최근 게시물 업데이트 시간", example = "2025-10-10 20:00:00")
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
