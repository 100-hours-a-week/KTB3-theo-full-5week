package com.example.KTB_4WEEK.exception.auth;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class UnAuthorizedException extends BusinessException {
    private ErrorCode errorCode;

    public UnAuthorizedException() {
        super(ErrorCode.UNAUTHORIZED);
    }
}
