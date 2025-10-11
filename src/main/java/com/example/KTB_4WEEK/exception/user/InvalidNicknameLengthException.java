package com.example.KTB_4WEEK.exception.user;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class InvalidNicknameLengthException extends BusinessException {

    public InvalidNicknameLengthException() {
        super(ErrorCode.INVALID_NICKNAME_LENGTH);
    }

}
