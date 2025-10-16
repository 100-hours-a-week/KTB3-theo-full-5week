package com.example.KTB_5WEEK.util.validator;

import com.example.KTB_5WEEK.exception.user.InvalidEmailException;
import com.example.KTB_5WEEK.exception.user.InvalidPasswordException;
import com.example.KTB_5WEEK.exception.user.InvalidNicknameLengthException;
import com.example.KTB_5WEEK.exception.user.InvalidUserIdRangeException;
import org.springframework.stereotype.Component;

@Component
public class UserValidator extends Validator{
    /**
     * UserValidator exports these Function
     * @ validPassword(String password)
     * @ validEmail(String email)
     * @ validNickname(String nickname)
     * **/
    // 비밀번호 검증
    public void validPassword(String password) {
        matchesPasswordPattern(password);
    }

    // 이메일 검증
    public void validEmail(String email) {
        matchesEmailPattern(email);
    }

    // 닉네임 검증
    public void validNickname(String nickname) {
        validateNicknameLength(nickname);
        validateWhiteSpace(nickname);
    }

    // UserId 검증
    public void validUserId(long userId) {
        validateUserIdaRange(userId);
    }

    /**
     * UserValidator use these Function internal
     */
    // 닉네임 길이 검사
    private void validateNicknameLength(String nickname) {
        if (!nickname.matches("^.{1,10}$")) {
            throw new InvalidNicknameLengthException();
        }
    }

    // 비밀번호 패턴 검사
    private void matchesPasswordPattern(String password) {
        if (!password.matches("^(?=.*[A-Z])" +
                "(?=.*[a-z])" +
                "(?=.*\\d)" +
                "(?=.*[~`!@#$%^&*()_\\-+={}\\[\\]|\\\\:;\\\"'<>,.?/])" +
                "(?!.*\\s)" +
                ".{8,20}$")) {
            throw new InvalidPasswordException();
        }
    }

    // 이메일 패턴 검사
    private void matchesEmailPattern(String email) {
        // RFC 5332 Email pattern
        if (!email.matches("[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new InvalidEmailException();
        }
    }

    // UserId : long > 0 검사
    private void validateUserIdaRange(long userId) {
        if (userId <= 0) {
            throw new InvalidUserIdRangeException();
        }
    }
}
