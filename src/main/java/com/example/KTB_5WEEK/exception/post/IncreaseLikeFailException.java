package com.example.KTB_5WEEK.exception.post;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class IncreaseLikeFailException extends BusinessException {
    public IncreaseLikeFailException() {
        super(ErrorCode.INCREASE_LIKE_FAIL);
    }
}
