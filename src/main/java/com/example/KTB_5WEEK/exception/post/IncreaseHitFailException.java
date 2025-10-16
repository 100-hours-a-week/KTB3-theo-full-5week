package com.example.KTB_5WEEK.exception.post;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class IncreaseHitFailException extends BusinessException {
    public IncreaseHitFailException() {
        super(ErrorCode.INCREASE_HIT_FAIL);
    }
}
