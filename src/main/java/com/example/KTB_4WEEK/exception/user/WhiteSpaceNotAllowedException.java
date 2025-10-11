package com.example.KTB_4WEEK.exception.user;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class WhiteSpaceNotAllowedException extends BusinessException {
    public WhiteSpaceNotAllowedException() {
        super(ErrorCode.WHITESPACE_NOT_ALLOWED);
    }
}
