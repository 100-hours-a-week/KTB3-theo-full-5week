package com.example.KTB_5WEEK.exception.post;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class PostCreateException extends BusinessException {

    public PostCreateException() {
        super(ErrorCode.POST_CREATE_ERROR);
    }
}
