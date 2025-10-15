package com.example.KTB_4WEEK.dto.response.post.comment;

import com.example.KTB_4WEEK.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FindCommentsResponseDto {
    @Schema(description = "조회한 댓글이 속한 게시글 PK", example = "1")
    private long postId;
    @Schema(description = "댓글 전체 페이지 개수", example = "10")
    private int totalPages;
    @Schema(description = "게시글에 속한 전체 댓글의 개수", example = "20")
    private int total_count;
    @Schema(description = "한 페이지마다 보여줄 댓글의 개수", example = "10")
    private int pageSize;
    @Schema(description = "현재 참조하는 페이지 번호", example = "1")
    private int pageIndex;
    @Schema(description = "현재 페이지를 기준으로 다음 페이지 유무", example = "true/false")
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

