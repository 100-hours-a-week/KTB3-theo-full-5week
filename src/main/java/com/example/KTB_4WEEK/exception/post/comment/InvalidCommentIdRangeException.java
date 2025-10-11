package com.example.KTB_4WEEK.exception.post.comment;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class InvalidCommentIdRangeException extends BusinessException {
    public InvalidCommentIdRangeException() {
        super(ErrorCode.INVALID_POST_ID);
    }
}
