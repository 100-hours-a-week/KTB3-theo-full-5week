package com.example.KTB_4WEEK.exception.post.comment;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class CommentDeleteException extends BusinessException {

    public CommentDeleteException() {
        super(ErrorCode.COMMENT_DELETE_ERROR);
    }

}
