package com.example.KTB_4WEEK.util.validator;

import com.example.KTB_4WEEK.exception.handler.ErrorCode;
import com.example.KTB_4WEEK.exception.user.WhiteSpaceNotAllowedException;

public class Validator {

    // 공백 문자열 검사
    protected void validateWhiteSpace(String target) {
        if (target.contains(" ")) {
            throw new WhiteSpaceNotAllowedException();
        }
    }
}
