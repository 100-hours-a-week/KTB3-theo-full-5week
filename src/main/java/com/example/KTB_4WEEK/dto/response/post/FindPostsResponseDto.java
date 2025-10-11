package com.example.KTB_4WEEK.dto.response.post;

import java.util.List;

public class FindPostsResponseDto {
    private int totalPages;
    private int totalCount;
    private int postPerPage;
    private int currentPage;
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
