package com.example.KTB_4WEEK.exception.post;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class PostUpdateException extends BusinessException {

    public PostUpdateException() {
        super(ErrorCode.POST_UPDATE_ERROR);
    }

}
