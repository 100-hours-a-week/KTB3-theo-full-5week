package com.example.KTB_4WEEK.exception.user;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class NicknameUpdateException extends BusinessException {
    public NicknameUpdateException() {
        super(ErrorCode.NICKNAME_UPDATE_ERROR);
    }
}
