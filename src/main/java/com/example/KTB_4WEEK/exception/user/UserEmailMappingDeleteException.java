package com.example.KTB_4WEEK.exception.user;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class UserEmailMappingDeleteException extends BusinessException {
    public UserEmailMappingDeleteException() {
        super(ErrorCode.FAIL_USER_EMAIL_MAPPING_DELETE);
    }
}
