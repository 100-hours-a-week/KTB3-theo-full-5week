package com.example.KTB_4WEEK.exception.post.comment;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class CommentCreateException extends BusinessException {

    public CommentCreateException() {
        super(ErrorCode.COMMENT_CREATE_ERROR);
    }

}
