package com.example.KTB_4WEEK.exception.user;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class UserDeleteException extends BusinessException {

    public UserDeleteException() {
        super(ErrorCode.USER_DELETE_ERROR);
    }

}
