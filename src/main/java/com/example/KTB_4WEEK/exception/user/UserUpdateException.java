package com.example.KTB_4WEEK.exception.user;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class UserUpdateException extends BusinessException {

    public UserUpdateException() {
        super(ErrorCode.USER_UPDATE_ERROR);
    }
}
