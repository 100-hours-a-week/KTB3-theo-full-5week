package com.example.KTB_4WEEK.exception.post;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;


public class InvalidPostIdRangeException extends BusinessException {
    public InvalidPostIdRangeException() {
        super(ErrorCode.INVALID_POST_ID);
    }
}
