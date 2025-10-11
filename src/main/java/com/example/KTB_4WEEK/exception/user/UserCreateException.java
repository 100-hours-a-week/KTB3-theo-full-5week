package com.example.KTB_4WEEK.exception.user;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class UserCreateException extends BusinessException {
    public UserCreateException() {
        super(ErrorCode.USER_CREATE_ERROR);
    }
}
