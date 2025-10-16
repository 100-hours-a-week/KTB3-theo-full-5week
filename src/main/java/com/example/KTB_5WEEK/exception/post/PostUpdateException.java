package com.example.KTB_5WEEK.exception.post;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class PostUpdateException extends BusinessException {

    public PostUpdateException() {
        super(ErrorCode.POST_UPDATE_ERROR);
    }

}
