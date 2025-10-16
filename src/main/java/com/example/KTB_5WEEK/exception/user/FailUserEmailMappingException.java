package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class FailUserEmailMappingException extends BusinessException {
    public FailUserEmailMappingException() {
        super(ErrorCode.FAIL_USER_EMAIL_MAPPING);
    }
}
