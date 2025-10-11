package com.example.KTB_4WEEK.exception.post;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class PostCreateException extends BusinessException {

    public PostCreateException() {
        super(ErrorCode.POST_CREATE_ERROR);
    }
}
