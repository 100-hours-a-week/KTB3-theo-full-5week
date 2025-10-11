package com.example.KTB_4WEEK.exception.post;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class PostDeleteException extends BusinessException {

    public PostDeleteException() {
        super(ErrorCode.POST_DELETE_ERROR);
    }

}
