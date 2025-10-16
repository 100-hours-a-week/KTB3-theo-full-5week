package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class InvalidUserIdRangeException extends BusinessException {
    public InvalidUserIdRangeException() {
        super(ErrorCode.INVALID_USER_ID);
    }
}
