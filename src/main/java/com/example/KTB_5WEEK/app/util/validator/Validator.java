package com.example.KTB_5WEEK.app.util.validator;

import com.example.KTB_5WEEK.user.exception.WhiteSpaceNotAllowedException;

public class Validator {

    // 공백 문자열 검사
    protected void validateWhiteSpace(String target) {
        if (target.contains(" ")) {
            throw new WhiteSpaceNotAllowedException();
        }
    }
}
