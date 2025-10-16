package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class InvalidNicknameLengthException extends BusinessException {

    public InvalidNicknameLengthException() {
        super(ErrorCode.INVALID_NICKNAME_LENGTH);
    }

}
