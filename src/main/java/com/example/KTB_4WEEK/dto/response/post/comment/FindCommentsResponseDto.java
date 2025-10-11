package com.example.KTB_4WEEK.dto.response.post.comment;

import com.example.KTB_4WEEK.entity.Comment;
import java.util.List;

public class FindCommentsResponseDto {
    private long postId;
    private int totalPages;
    private int total_count;
    private int pageSize;
    private int pageIndex;
    private boolean hasNext;

    private List<FindCommentResponseDto> comments;

    public FindCommentsResponseDto(long postId, int totalPages, int total_count,
                                   int pageSize, int pageIndex, boolean hasNext,
                                   List<FindCommentResponseDto> comments) {
        this.postId = postId;
        this.totalPages = totalPages;
        this.total_count = total_count;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.hasNext = hasNext;
        this.comments = comments;
    }

    public long getPostId() {
        return postId;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotal_count() {
        return total_count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public List<FindCommentResponseDto> getComments() {
        return comments;
    }
}

