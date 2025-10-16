package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class UserCreateException extends BusinessException {
    public UserCreateException() {
        super(ErrorCode.USER_CREATE_ERROR);
    }
}
