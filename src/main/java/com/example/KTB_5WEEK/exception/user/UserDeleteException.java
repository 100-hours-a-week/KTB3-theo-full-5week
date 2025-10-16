package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class UserDeleteException extends BusinessException {

    public UserDeleteException() {
        super(ErrorCode.USER_DELETE_ERROR);
    }

}
