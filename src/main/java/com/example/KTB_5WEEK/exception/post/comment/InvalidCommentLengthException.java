package com.example.KTB_5WEEK.exception.post.comment;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class InvalidCommentLengthException extends BusinessException {
    public InvalidCommentLengthException() {
        super(ErrorCode.NO_COMMENT_NOT_ALLOWED);
    }
}
