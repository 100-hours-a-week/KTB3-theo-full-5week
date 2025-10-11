package com.example.KTB_4WEEK.exception.user;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class NicknameAlreadyRegisteredException extends BusinessException {
    public NicknameAlreadyRegisteredException() {
        super(ErrorCode.NICKNAME_ALREADY_REGISTERED);
    }

}
