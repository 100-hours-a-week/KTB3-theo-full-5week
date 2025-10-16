package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class NicknameUpdateException extends BusinessException {
    public NicknameUpdateException() {
        super(ErrorCode.NICKNAME_UPDATE_ERROR);
    }
}
