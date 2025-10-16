package com.example.KTB_5WEEK.exception.user;

import com.example.KTB_5WEEK.exception.common.BusinessException;
import com.example.KTB_5WEEK.exception.handler.ErrorCode;

public class UserEmailMappingDeleteException extends BusinessException {
    public UserEmailMappingDeleteException() {
        super(ErrorCode.FAIL_USER_EMAIL_MAPPING_DELETE);
    }
}
