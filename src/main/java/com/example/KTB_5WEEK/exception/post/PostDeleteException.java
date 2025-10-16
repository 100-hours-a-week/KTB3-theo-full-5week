package com.example.KTB_5WEEK.exception.post;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class PostDeleteException extends BusinessException {

    public PostDeleteException() {
        super(ErrorCode.POST_DELETE_ERROR);
    }

}
