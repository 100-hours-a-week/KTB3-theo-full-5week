package com.example.KTB_4WEEK.exception.common;

import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
