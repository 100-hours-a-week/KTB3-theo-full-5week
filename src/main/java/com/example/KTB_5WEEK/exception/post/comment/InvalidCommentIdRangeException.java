package com.example.KTB_5WEEK.exception.post.comment;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class InvalidCommentIdRangeException extends BusinessException {
    public InvalidCommentIdRangeException() {
        super(ErrorCode.INVALID_POST_ID);
    }
}
