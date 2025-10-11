package com.example.KTB_4WEEK.exception.post;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import com.example.KTB_4WEEK.exception.handler.ErrorCode;

public class InvalidPostTitleLengthException extends BusinessException {
    public InvalidPostTitleLengthException() {
        super(ErrorCode.POST_TITLE_LENGTH_OVER);
    }
}
