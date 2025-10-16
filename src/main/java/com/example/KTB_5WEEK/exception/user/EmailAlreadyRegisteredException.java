package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class EmailAlreadyRegisteredException extends BusinessException {
    public EmailAlreadyRegisteredException() {
        super(ErrorCode.EMAIL_ALREADY_REGISTERED);
    }

}
