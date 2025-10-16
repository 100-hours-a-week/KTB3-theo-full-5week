package com.example.KTB_5WEEK.exception.auth;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class UnAuthorizedException extends BusinessException {
    private ErrorCode errorCode;

    public UnAuthorizedException() {
        super(ErrorCode.UNAUTHORIZED);
    }
}
