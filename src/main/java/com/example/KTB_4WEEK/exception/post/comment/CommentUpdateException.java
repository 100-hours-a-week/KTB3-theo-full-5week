package com.example.KTB_4WEEK.exception.post.comment;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class CommentUpdateException extends BusinessException {

    public CommentUpdateException() {
        super(ErrorCode.COMMENT_UPDATE_ERROR);
    }

}
