package com.example.KTB_4WEEK.exception.post;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class IncreaseHitFailException extends BusinessException {
    public IncreaseHitFailException() {
        super(ErrorCode.INCREASE_HIT_FAIL);
    }
}
