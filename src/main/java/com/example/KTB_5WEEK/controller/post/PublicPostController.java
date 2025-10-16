package com.example.KTB_5WEEK.controller.post;

import com.example.KTB_5WEEK.swagger.controller.post.PostApiDoc;
import com.example.KTB_5WEEK.dto.request.post.CreatePostRequestDto;
import com.example.KTB_5WEEK.dto.request.post.comment.UpdateCommentRequestDto;
import com.example.KTB_5WEEK.dto.response.common.BaseResponse;
import com.example.KTB_5WEEK.service.post.PublicPostService;
import com.example.KTB_5WEEK.dto.request.post.UpdateMyPostRequestDto;
import com.example.KTB_5WEEK.dto.request.post.comment.CreateCommentRequestDto;

import com.example.KTB_5WEEK.util.validator.PostValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PublicPostController implements PostApiDoc {

    private final PublicPostService publicPostService;
    private final PostValidator postValidator;

    public PublicPostController(PublicPostService publicPostService, PostValidator postValidator) {
        this.publicPostService = publicPostService;
        this.postValidator = postValidator;
    }

    /**
     * Get Mapping
     **/
    @GetMapping // 전체 게시글 목록 조회
    public ResponseEntity<BaseResponse> findPublicPosts(@RequestParam(name = "page", defaultValue = "1") int page) {
        BaseResponse response = publicPostService.findPosts(page);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{postId}") // 게시글 조회
    public ResponseEntity<BaseResponse> findPublicPostById(@PathVariable("postId") Long postId) {
        postValidator.validPostId(postId);
        BaseResponse response = publicPostService.findPostById(postId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{postId}/comment") // 게시글에 대한 댓글 조회
    public ResponseEntity<BaseResponse> findCommentByPostId(@PathVariable("postId") Long postId,
                                                            @RequestParam(name = "page", defaultValue = "1") int page) {
        postValidator.validPostId(postId);
        BaseResponse response = publicPostService.findCommentByPostId(postId, page);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Post Mapping
     **/
    @PostMapping // 게시글 생성
    public ResponseEntity<BaseResponse> createPublicPost(@RequestBody CreatePostRequestDto request) {
        postValidator.validPostTitle(request.getTitle());
        BaseResponse response = publicPostService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PostMapping("/{postId}/hit") // 조회 수 증가
    public ResponseEntity<BaseResponse> increaseHit(@PathVariable("postId") Long postId) {
        postValidator.validCommentId(postId);
        BaseResponse response = publicPostService.increaseHit(postId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/{postId}/like") // 좋아요 수 증가
    public ResponseEntity<BaseResponse> increaseLike(@PathVariable("postId") Long postId) {
        postValidator.validCommentId(postId);
        BaseResponse response = publicPostService.increaseLike(postId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("/{postId}/comment") // 댓글 등록
    public ResponseEntity<BaseResponse> createComment(@PathVariable("postId") Long postId,
                                                      @RequestBody CreateCommentRequestDto request) {
        postValidator.validCommentId(postId);
        postValidator.validComment(request.getContent());
        postValidator.validPostId(postId);
        BaseResponse response = publicPostService.createComment(postId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Patch Mapping
     **/
    @PatchMapping("/{postId}/comment/{commentId}") // 댓글 수정
    public ResponseEntity<BaseResponse> updateComment(@PathVariable("postId") Long postId,
                                                      @PathVariable("commentId") Long commentId,
                                                      @RequestBody UpdateCommentRequestDto request) {
        postValidator.validPostId(postId);
        postValidator.validCommentId(commentId);
        postValidator.validComment(request.getContent());
        BaseResponse response = publicPostService.updateCommentById(postId, commentId, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{postId}") // 나의 게시글 수정
    public ResponseEntity<BaseResponse> updatePublicPost(@PathVariable("postId") Long myPostId,
                                                         @RequestBody UpdateMyPostRequestDto request) {
        postValidator.validPostId(myPostId);
        postValidator.validPostTitle(request.getTitle());
        BaseResponse response = publicPostService.updateMyPost(myPostId, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Delete Mapping
     **/
    @DeleteMapping("/{postId}") // 게시글 삭제
    public ResponseEntity<BaseResponse> deletePostById(@PathVariable("postId") Long postId) {
        postValidator.validPostId(postId);
        BaseResponse response = publicPostService.deletePostById(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{postId}/comment/{commentId}") // 댓글 삭제
    public ResponseEntity<BaseResponse> deleteCommentById(@PathVariable("postId") Long postId,
                                                          @PathVariable("commentId") Long commentId) {
        postValidator.validPostId(postId);
        postValidator.validCommentId(commentId);
        BaseResponse response = publicPostService.deleteCommentById(postId, commentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
