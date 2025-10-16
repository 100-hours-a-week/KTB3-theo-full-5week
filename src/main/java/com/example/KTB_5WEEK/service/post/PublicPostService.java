package com.example.KTB_5WEEK.service.post;

import com.example.KTB_5WEEK.dto.request.post.UpdateMyPostRequestDto;
import com.example.KTB_5WEEK.dto.request.post.comment.CreateCommentRequestDto;
import com.example.KTB_5WEEK.dto.request.post.comment.UpdateCommentRequestDto;
import com.example.KTB_5WEEK.dto.response.common.BaseResponse;
import com.example.KTB_5WEEK.dto.response.common.ResponseMessage;
import com.example.KTB_5WEEK.dto.response.post.*;
import com.example.KTB_5WEEK.dto.response.post.comment.CreateCommentResponseDto;
import com.example.KTB_5WEEK.dto.response.post.comment.FindCommentResponseDto;
import com.example.KTB_5WEEK.dto.response.post.comment.FindCommentsResponseDto;
import com.example.KTB_5WEEK.dto.response.post.comment.UpdateCommentResponseDto;
import com.example.KTB_5WEEK.entity.Comment;
import com.example.KTB_5WEEK.exception.post.*;
import com.example.KTB_5WEEK.exception.post.comment.CommentDeleteException;
import com.example.KTB_5WEEK.exception.post.comment.CommentNotFoundException;
import com.example.KTB_5WEEK.exception.post.comment.CommentUpdateException;
import com.example.KTB_5WEEK.repository.post.PostRepository;
import com.example.KTB_5WEEK.dto.request.post.CreatePostRequestDto;
import com.example.KTB_5WEEK.exception.post.comment.CommentCreateException;
import com.example.KTB_5WEEK.entity.Post;
import com.example.KTB_5WEEK.util.paginationPolicy.CommentPaginationPolicy;
import com.example.KTB_5WEEK.util.paginationPolicy.PostPaginationPolicy;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicPostService {
    private final PostRepository postRepository;

    public PublicPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Post Service Business Logic & Convert <BaseResponse> Method
     **/
    // 게시글 생성
    public BaseResponse<CreateCommentResponseDto> createPost(CreatePostRequestDto req) {
        Post toSave = new Post(req.getAuthorId(), req.getTitle(), req.getArticle(), req.getArticleImage(), req.getCategory());
        Post saved = postRepository.createPost(toSave).orElseThrow(() -> new PostCreateException());
        return new BaseResponse(ResponseMessage.POST_REGISTER_SUCCESS, new CreatePostResponseDto(saved.getId()));
    }

    // 게시글 목록 조회
    public BaseResponse<FindPostsResponseDto> findPosts(int page) {
        List<Post> posts = postRepository.findAllPost();
        int totalPages = posts.size() / PostPaginationPolicy.DEFAULT.limit();
        totalPages = posts.size() % PostPaginationPolicy.DEFAULT.limit() > 0 ?
                totalPages + 1 : totalPages;

        int totalCount = posts.size();
        int postPerPage = PostPaginationPolicy.DEFAULT.limit();
        int currentPage = page;
        boolean hasNext = totalPages > currentPage;

        List<FindPostResponseDto> postDtoList = posts.stream()
                .filter(PostPaginationPolicy.DEFAULT.predicate())
                .sorted(PostPaginationPolicy.DEFAULT.comparator())
                .skip(PostPaginationPolicy.DEFAULT.offset(page))
                .limit(PostPaginationPolicy.DEFAULT.limit())
                .map(this::toFindPostResponseDto)
                .collect(Collectors.toCollection(ArrayList::new));

        return new BaseResponse(ResponseMessage.POSTS_LOAD_SUCCESS,
                new FindPostsResponseDto(totalPages, totalCount, postPerPage, currentPage, hasNext,
                        postDtoList));
    }

    // 게시글 조회
    public BaseResponse<FindPostResponseDto> findPostById(long id) {
        Post post = postRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());
        FindPostResponseDto findPostResponseDto = toFindPostResponseDto(post);
        return new BaseResponse(ResponseMessage.POST_INFO_LOAD_SUCCESS, findPostResponseDto);
    }

    // My Post 수정
    public BaseResponse<UpdateMyPostResponseDto> updateMyPost(long myPostId, UpdateMyPostRequestDto req) {

        Post originPost = postRepository.findPostById(myPostId).orElseThrow(() -> new PostNotFoundException());

        originPost.updateTitle(req.getTitle());
        originPost.updateArticle(req.getArticle());
        originPost.updateArticleImage(req.getArticleImage());
        originPost.updateCategory(req.getCategory());

        Post updatedPost = postRepository.updatePostById(myPostId, originPost).orElseThrow(() -> new PostUpdateException());

        return new BaseResponse(ResponseMessage.MY_POST_UPDATE_SUCCESS,
                new UpdateMyPostResponseDto(updatedPost.getId(), updatedPost.getTitle()
                        , updatedPost.getArticle(), updatedPost.getArticleImage(), updatedPost.getCategory(), updatedPost.getUpdatedAt()));
    }

    // 게시글 삭제 By Id
    public BaseResponse deletePostById(long id) {
        postRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());

        postRepository.deletePostById(id).orElseThrow(() -> new PostDeleteException());

        return new BaseResponse(ResponseMessage.POST_DELETE_SUCCESS, new Post());
    }

    // 게시글 조회 수 증가
    public BaseResponse<IncreaseHitResponseDto> increaseHit(long id) {
        Post toUpdate = postRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());
        toUpdate.increaseHit();

        Post updated = postRepository.updatePostById(id, toUpdate).orElseThrow(() -> new IncreaseHitFailException());
        return new BaseResponse(ResponseMessage.INCREASE_HIT_SUCCESS,
                new IncreaseHitResponseDto(updated.getId(), updated.getHit(), updated.getUpdatedAt()));
    }

    // 게시글 좋아요 수 증가
    public BaseResponse<IncreaseLikeResponseDto> increaseLike(long id) {
        Post toUpdate = postRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());
        toUpdate.increaseLike();

        Post updated = postRepository.updatePostById(id, toUpdate).orElseThrow(() -> new IncreaseLikeFailException());
        return new BaseResponse(ResponseMessage.INCREASE_LIKE_SUCCESS,
                new IncreaseLikeResponseDto(updated.getId(), updated.getHit(), updated.getUpdatedAt()));
    }

    // 댓글 등록
    public BaseResponse<CreateCommentResponseDto> createComment(long postId, CreateCommentRequestDto req) {
        postRepository.findPostById(postId).orElseThrow(() -> new PostNotFoundException());

        Comment toSave = new Comment(req.getUserId(), postId, req.getContent());
        Comment saved = postRepository.createComment(toSave).orElseThrow(() -> new CommentCreateException());

        return new BaseResponse(ResponseMessage.COMMENT_CREATE_SUCCESS,
                new CreateCommentResponseDto(saved.getId(), saved.getContent()));
    }

    // 댓글 조회 By Post Id
    public BaseResponse<FindCommentsResponseDto> findCommentByPostId(long postId, int page) {
        postRepository.findPostById(postId).orElseThrow(() -> new PostNotFoundException());

        List<Comment> comments = postRepository.findCommentsByPostId(postId);
        int totalPages = comments.size() / CommentPaginationPolicy.DEFAULT.limit();
        totalPages = (comments.size() % CommentPaginationPolicy.DEFAULT.limit()) > 0
                ? totalPages + 1 : totalPages;
        int totalCount = comments.size();
        int commentPerPage = CommentPaginationPolicy.DEFAULT.limit();
        int currentPage = page;
        boolean hasNext = (totalPages > currentPage);

        List<FindCommentResponseDto> commentDtoList = comments.stream()
                .filter(CommentPaginationPolicy.DEFAULT.predicate())
                .sorted(CommentPaginationPolicy.DEFAULT.comparator())
                .skip(CommentPaginationPolicy.DEFAULT.offset(page))
                .limit(CommentPaginationPolicy.DEFAULT.limit())
                .map(this::toFindCommentResponseDto)
                .collect(Collectors.toCollection(ArrayList::new));

        return new BaseResponse(ResponseMessage.COMMENTS_LOAD_SUCCESS,
                new FindCommentsResponseDto(postId, totalPages, totalCount, commentPerPage, currentPage, hasNext,
                        commentDtoList));
    }

    // 댓글 조회 By Comment Id
    public BaseResponse<FindCommentResponseDto> findCommentByCommentId(long id) {
        Comment comment = postRepository.findCommentById(id).orElseThrow(() -> new CommentNotFoundException());

        return new BaseResponse(ResponseMessage.COMMENT_LOAD_SUCCESS,
                new FindCommentResponseDto(comment.getId(), comment.getUserId(), comment.getContent()
                        , comment.getCreatedAt(), comment.getUpdatedAt()));
    }

    // 댓글 수정 By Comment Id
    public BaseResponse<UpdateCommentResponseDto> updateCommentById(long postId, long commentId, UpdateCommentRequestDto req) {
        postRepository.findPostById(postId).orElseThrow(() -> new PostNotFoundException());

        Comment originComment = postRepository.findCommentById(commentId).orElseThrow(() -> new CommentNotFoundException());

        originComment.updateContent(req.getContent());

        Comment updatedComment = postRepository.updateCommentById(commentId, originComment).orElseThrow(() -> new CommentUpdateException());

        return new BaseResponse(ResponseMessage.COMMENT_UPDATE_SUCCESS,
                new UpdateCommentResponseDto(updatedComment.getId(), updatedComment.getPostId(), updatedComment.getUserId(),
                        updatedComment.getContent(), updatedComment.getCreatedAt(), updatedComment.getUpdatedAt()));
    }

    // 댓글 삭제
    public BaseResponse deleteCommentById(long postId, long commentId) {
        postRepository.findPostById(postId).orElseThrow(() -> new PostNotFoundException());

        postRepository.deleteCommentById(commentId).orElseThrow(() -> new CommentDeleteException());

        return new BaseResponse(ResponseMessage.COMMENT_DELETE_SUCCESS, new Comment());
    }

    /**
     * Entity -> Response DTO
     **/
    // 게시글 조회 : Post -> ResponseDTO
    private FindPostResponseDto toFindPostResponseDto(Post post) {
        return new FindPostResponseDto(post.getId(), post.getAuthorId(), post.getTitle(),
                post.getArticle(), post.getArticleImage(), post.getCategory(),
                post.getHit(), post.getLike(), post.getCreatedAt(), post.getUpdatedAt(),
                post.isDeleted());
    }

    // 댓글 조회 By Comment ID -> Response DTO
    private FindCommentResponseDto toFindCommentResponseDto(Comment comment) {
        return new FindCommentResponseDto(comment.getId(), comment.getUserId(), comment.getContent()
                , comment.getCreatedAt(), comment.getUpdatedAt());
    }
}
