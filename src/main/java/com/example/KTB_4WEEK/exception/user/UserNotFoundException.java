package com.example.KTB_4WEEK.exception.user;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
