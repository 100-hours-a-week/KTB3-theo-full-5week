package com.example.KTB_4WEEK.repository.post;

import com.example.KTB_4WEEK.exception.post.comment.CommentNotFoundException;
import com.example.KTB_4WEEK.util.table.PostTable;
import com.example.KTB_4WEEK.util.table.CommentTable;
import com.example.KTB_4WEEK.entity.Post;
import com.example.KTB_4WEEK.entity.Comment;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public class PublicPostRepository implements PostRepository {
    private PostTable postTable;
    private CommentTable commentTable;

    public PublicPostRepository(PostTable postTable, CommentTable commentTable) {
        this.postTable = postTable;
        this.commentTable = commentTable;
    }

    @Override // 전체 Post 조회
    public List<Post> findAllPost() {
        return postTable.getTable().values().stream().toList();
    }

    @Override // Post 생성
    public Optional<Post> createPost(Post post) {
        long postId = postTable.increaseSequence();
        post.setId(postId);
        postTable.getTable().put(postId, post);
        return Optional.ofNullable(postTable.getTable().get(postId));
    }

    @Override // Post PK 조회
    public Optional<Post> findPostById(long id) {
        return Optional.ofNullable(postTable.getTable().get(id));
    }

    @Override // Post 수정 By Id
    public Optional<Post> updatePostById(long id, Post target) {
        target.setUpdatedAt(LocalDateTime.now());
        postTable.getTable().put(id, target);
        return Optional.ofNullable(postTable.getTable().get(id));
    }

    @Override // Post 삭제 By Id
    public Optional<Post> deletePostById(long id) {
        Post deletePost = findPostById(id).get();
        deletePost.setDeleted(true);
        updatePostById(id, deletePost);
        return Optional.ofNullable(postTable.getTable().remove(id));
    }

    // 댓글 생성
    public Optional<Comment> createComment(Comment comment) {
        long commentId = commentTable.increaseSequence();
        comment.setId(commentId);
        commentTable.getTable().put(commentId, comment);
        return Optional.ofNullable(commentTable.getTable().get(commentId));
    }

    // 모든 Comment 조회 By Post Id
    public List<Comment> findCommentsByPostId(long id) {
        return commentTable.getTable().values().stream()
                .filter(post -> post.getPostId() == id).toList();
    }

    // Comment 조회 By Comment Id
    public Optional<Comment> findCommentById(long id) {
        return Optional.ofNullable(commentTable.getTable().get(id));
    }

    // Comment 수정 By ID
    public Optional<Comment> updateCommentById(long id, Comment target) {
        target.setUpdatedAt(LocalDateTime.now());
        commentTable.getTable().put(id, target);
        return Optional.ofNullable(commentTable.getTable().get(id));
    }

    // Comment 삭제 By ID
    public Optional<Comment> deleteCommentById(long id) {
        Comment deleteComment = findCommentById(id).orElseThrow(() -> new CommentNotFoundException());
        deleteComment.setDeleted(true);
        updateCommentById(id, deleteComment);
        return Optional.ofNullable(commentTable.getTable().remove(id));
    }
}
