package com.example.KTB_5WEEK.exception.post.comment;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class CommentCreateException extends BusinessException {

    public CommentCreateException() {
        super(ErrorCode.COMMENT_CREATE_ERROR);
    }

}
