package com.example.KTB_5WEEK.app.util.validator;

import com.example.KTB_5WEEK.post.exception.InvalidPostIdRangeException;
import com.example.KTB_5WEEK.post.exception.InvalidPostTitleLengthException;
import com.example.KTB_5WEEK.post.exception.comment.InvalidCommentIdRangeException;
import com.example.KTB_5WEEK.post.exception.comment.InvalidCommentLengthException;
import org.springframework.stereotype.Component;

@Component
public class PostValidator extends Validator {
    public void validPostTitle(String title) {
        validatePostTitleLength(title);
    }

    public void validComment(String comment) {
        validateCommentLength(comment);
    }

    public void validPostId(long postId) {
        validatePostIdRange(postId);
    }

    public void validCommentId(long commentId) {
        validateCommentIdRange(commentId);
    }

    private void validatePostTitleLength(String title) {
        if (!title.matches("^.{1,26}$")) {
            throw new InvalidPostTitleLengthException();
        }
    }

    private void validateCommentLength(String comment) {
        if (comment.length() <= 0) {
            throw new InvalidCommentLengthException();

        }
    }

    private void validatePostIdRange(long postId) {
        if (postId <= 0) {
            throw new InvalidPostIdRangeException();
        }
    }

    private void validateCommentIdRange(long commentId) {
        if (commentId <= 0) {
            throw new InvalidCommentIdRangeException();
        }
    }
}
