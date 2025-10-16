package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class InvalidEmailException extends BusinessException {

    public InvalidEmailException() {
        super(ErrorCode.INVALID_EMAIL);
    }

}
