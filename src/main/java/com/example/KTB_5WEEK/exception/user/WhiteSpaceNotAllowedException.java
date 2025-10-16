package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class WhiteSpaceNotAllowedException extends BusinessException {
    public WhiteSpaceNotAllowedException() {
        super(ErrorCode.WHITESPACE_NOT_ALLOWED);
    }
}
