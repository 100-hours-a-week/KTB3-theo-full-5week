package com.example.KTB_5WEEK.exception.post.comment;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class CommentDeleteException extends BusinessException {

    public CommentDeleteException() {
        super(ErrorCode.COMMENT_DELETE_ERROR);
    }

}
