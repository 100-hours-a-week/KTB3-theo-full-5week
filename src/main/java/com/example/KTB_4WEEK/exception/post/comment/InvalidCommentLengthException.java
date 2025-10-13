package com.example.KTB_4WEEK.exception.post.comment;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class InvalidCommentLengthException extends BusinessException {
    public InvalidCommentLengthException() {
        super(ErrorCode.NO_COMMENT_NOT_ALLOWED);
    }
}
