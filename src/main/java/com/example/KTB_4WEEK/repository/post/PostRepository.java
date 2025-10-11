package com.example.KTB_4WEEK.repository.post;

import java.util.List;
import java.util.Optional;

import com.example.KTB_4WEEK.entity.Post;
import com.example.KTB_4WEEK.entity.Comment;

public interface PostRepository {

    List<Post> findAllPost();

    Optional<Post> createPost(Post post);

    Optional<Post> findPostById(long id);

    Optional<Post> updatePostById(long id, Post target);

    Optional<Post> deletePostById(long id);

    List<Comment> findCommentsByPostId(long id);

    Optional<Comment> createComment(Comment comment);

    Optional<Comment> findCommentById(long id);

    Optional<Comment> updateCommentById(long id, Comment target);

    public Optional<Comment> deleteCommentById(long id);
}
