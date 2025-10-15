package com.example.KTB_4WEEK.service.user;


import com.example.KTB_4WEEK.dto.request.user.*;
import com.example.KTB_4WEEK.dto.response.common.BaseResponse;
import com.example.KTB_4WEEK.dto.response.common.ResponseMessage;
import com.example.KTB_4WEEK.dto.response.user.*;
import com.example.KTB_4WEEK.entity.User;
import com.example.KTB_4WEEK.exception.user.*;
import com.example.KTB_4WEEK.repository.user.UserRepository;
import com.example.KTB_4WEEK.repository.user.email.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicUserService {
    private final UserRepository userRepository;
    private final EmailRepository emailRepository;

    // 생성자 DI
    public PublicUserService(UserRepository publicUserRepository, EmailRepository emailRepository) {
        this.userRepository = publicUserRepository;
        this.emailRepository = emailRepository;
    }

    /**
     * User Service Business Logic & Convert <BaseResponse> Method
     **/
    // 로그인
    public BaseResponse<LoginResponseDto> login(LoginRequestDto req) {
        String email = req.getEmail();
        String password = req.getPassword();

        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return new BaseResponse(ResponseMessage.LOGIN_SUCCESS, new LoginResponseDto(user.getId(), true));
            }
        }
        throw new UserNotFoundException();
    }

    // 로그아웃
    public BaseResponse logout() {
        return new BaseResponse(ResponseMessage.LOGOUT_SUCCESS, new User());
    }

    // 회원가입
    public BaseResponse<RegistUserResponseDto> register(RegistUserRequestDto req) {
        String email = req.getEmail();
        String nickname = req.getNickname();

        if (checkEmailAvailability(email)) throw new EmailAlreadyRegisteredException();
        if (checkNicknameAvailability(nickname)) throw new NicknameAlreadyRegisteredException();

        User toSave = new User(email, req.getPassword(), req.getNickname(), req.getProfileImage());
        User saved = userRepository.regist(toSave).orElseThrow(() -> new UserCreateException());

        mapUserByEmail(saved);
        return new BaseResponse(ResponseMessage.USER_REGISTER_SUCCESS, new RegistUserResponseDto(saved.getId()));

    }

    // 이메일 : 유저 매핑 <- Search more Fast
    private void mapUserByEmail(User user) {
        emailRepository.mapUserByEMail(user).orElseThrow(() -> new FailUserEmailMappingException());
    }

    // 회원정보 조회
    public BaseResponse<FindUserResponseDto> findById(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        return new BaseResponse(ResponseMessage.USERINFO_LOAD_SUCCESS,
                new FindUserResponseDto(user.getId(), user.getEmail(), user.getNickname(),
                        user.getProfileImage(), user.getCreatedAt(), user.getUpdatedAt()));
    }

    // 회원정보 삭제
    public BaseResponse deleteById(long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());

        userRepository.deleteById(id).orElseThrow(() -> new UserDeleteException());

        return new BaseResponse(ResponseMessage.USER_DELETE_SUCCESS, new User());
    }

    // 닉네임 중복 검사
    public BaseResponse<CheckNicknameAvailabilityResponseDto> doubleCheckNickname(CheckNicknameAvailabilityRequestDto req) {
        String nickname = req.getNickname();
        if (checkNicknameAvailability(nickname)) {
            return new BaseResponse(ResponseMessage.NICKNAME_IS_NOT_AVAILABLE,
                    new CheckNicknameAvailabilityResponseDto(nickname, false));
        }
        return new BaseResponse(ResponseMessage.NICKNAME_IS_AVAILABLE,
                new CheckNicknameAvailabilityResponseDto(nickname, true));
    }

    // 이메일 중복 검사
    public BaseResponse<CheckEmailAvailabilityResponseDto> doubleCheckEmail(CheckEmailAvailabilityRequestDto req) {
        String email = req.getEmail();
        if (checkEmailAvailability(email)) {
            return new BaseResponse(ResponseMessage.EMAIL_IS_NOT_AVAILABLE,
                    new CheckEmailAvailabilityResponseDto(email, false));
        }
        return new BaseResponse(ResponseMessage.EMAIL_IS_AVAILABLE,
                new CheckEmailAvailabilityResponseDto(email, true));
    }


    // 닉네임 수정
    public BaseResponse<UpdateNicknameResponseDto> editNickname(long userId, NicknameEditRequestDto req) {
        String nickname = req.getNickname();

        if (checkNicknameAvailability(nickname)) throw new NicknameAlreadyRegisteredException();

        User toUpdate = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        toUpdate.updateNickname(nickname);

        User updated = userRepository.updateById(userId, toUpdate).orElseThrow(() -> new NicknameUpdateException());

        return new BaseResponse(ResponseMessage.NICKNAME_EDIT_SUCCESS, new UpdateNicknameResponseDto(
                updated.getId(), updated.getNickname(), updated.getCreatedAt()));
    }

    // 비밀번호 변경
    public BaseResponse changePassword(long userId, PasswordChangeRequestDto req) {
        String password = req.getPassword();

        User toUpdate = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        toUpdate.updatePassword(password);

        User updated = userRepository.updateById(userId, toUpdate).orElseThrow(() -> new UserUpdateException());

        return new BaseResponse(ResponseMessage.PASSWORD_CHANGE_SUCCESS,
                new UpdatePasswordResponseDto(updated.getId()));
    }

    /**
     * User Service Common Function
     **/

    // 닉네임 중복 검사
    private boolean checkNicknameAvailability(String nickname) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }


    // 이메일 중복 검사
    private boolean checkEmailAvailability(String email) {
        return emailRepository.findByEmail(email).isPresent();
    }
}
