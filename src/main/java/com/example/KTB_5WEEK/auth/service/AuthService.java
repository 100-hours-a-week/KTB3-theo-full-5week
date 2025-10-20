package com.example.KTB_5WEEK.auth.service;

import com.example.KTB_5WEEK.app.aop.aspect.log.Loggable;
import com.example.KTB_5WEEK.app.response.BaseResponse;
import com.example.KTB_5WEEK.app.response.ResponseMessage;
import com.example.KTB_5WEEK.user.dto.request.LoginRequestDto;
import com.example.KTB_5WEEK.user.dto.response.LoginResponseDto;
import com.example.KTB_5WEEK.user.entity.User;
import com.example.KTB_5WEEK.user.exception.UserNotFoundException;
import com.example.KTB_5WEEK.user.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Loggable
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

    @Loggable
    public BaseResponse logout() {
        return new BaseResponse(ResponseMessage.LOGOUT_SUCCESS, new User());
    }

}
