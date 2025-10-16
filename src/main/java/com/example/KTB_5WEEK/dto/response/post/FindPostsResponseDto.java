package com.example.KTB_5WEEK.dto.response.post;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FindPostsResponseDto {
    @Schema(description = "게시글 전체 페이지 개수", example = "20")
    private int totalPages;
    @Schema(description = "조회한 게시글 총 개수", example = "100")
    private int totalCount;
    @Schema(description = "한 페이지마다 보여줄 게시글 개수", example = "10")
    private int postPerPage;
    @Schema(description = "현재 페이지 인덱스", example = "1")
    private int currentPage;
    @Schema(description = "현재 페이지를 기준으로 다음 페이지 유무", example = "true/false")
    private boolean hasNext;

    private List<FindPostResponseDto> posts;

    public FindPostsResponseDto(int totalPages, int totalCount, int postPerPage,
                                int currentPage, boolean hasNext,
                                List<FindPostResponseDto> posts) {
        this.totalPages = totalPages;
        this.totalCount = totalCount;
        this.postPerPage = postPerPage;
        this.currentPage = currentPage;
        this.hasNext = hasNext;
        this.posts = posts;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPostPerPage() {
        return postPerPage;
    }

    public int getPageIndex() {
        return currentPage;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public List<FindPostResponseDto> getPosts() {
        return posts;
    }
}
