package com.example.KTB_4WEEK.controller.user;

import com.example.KTB_4WEEK.dto.request.user.*;
import com.example.KTB_4WEEK.dto.response.common.BaseResponse;
import com.example.KTB_4WEEK.service.auth.TokenService;
import com.example.KTB_4WEEK.service.user.PublicUserService;
import com.example.KTB_4WEEK.util.validator.UserValidator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/user")
public class PublicUserController {

    private final PublicUserService publicUserService;
    private final UserValidator userValidator;

    public PublicUserController(PublicUserService publicUserService, UserValidator userValidator) {
        this.publicUserService = publicUserService;
        this.userValidator = userValidator;
    }

    /**
     * Get Mapping
     **/
    @GetMapping("/{userId}") // 회원정보 조회
    public ResponseEntity<BaseResponse> findByPublicUserId(@PathVariable("userId") Long userId) {
        BaseResponse response = publicUserService.findById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Post Mapping
     **/
    @PostMapping // 회원가입
    public ResponseEntity<BaseResponse> createPublicUser(@RequestBody RegistUserRequestDto request) {
        userValidator.validEmail(request.getEmail());
        userValidator.validPassword(request.getPassword());
        userValidator.validNickname(request.getNickname());
        BaseResponse response = publicUserService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/logout") // 로그아웃
    public ResponseEntity<BaseResponse> logout(HttpServletRequest request) {
        BaseResponse response = publicUserService.logout();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @PostMapping("/nickname/double-check") // 닉네입 중복 확인
    public ResponseEntity<BaseResponse> doubleCheckNickname(@RequestBody CheckNicknameAvailabilityRequestDto request) {
        userValidator.validNickname(request.getNickname());
        BaseResponse response = publicUserService.doubleCheckNickname(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/email/double-check") // 이메일 중복 확인
    public ResponseEntity<BaseResponse> doubleCheckEmail(@RequestBody CheckEmailAvailabilityRequestDto request) {
        userValidator.validEmail(request.getEmail());
        BaseResponse response = publicUserService.doubleCheckEmail(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Patch Mapping
     **/
    @PatchMapping("/{userId}/nickname") // 닉네임 수정
    public ResponseEntity<BaseResponse> editNickName(@PathVariable("userId") Long userId,
                                                     @RequestBody NicknameEditRequestDto request) {
        userValidator.validNickname(request.getNickname());
        BaseResponse response = publicUserService.editNickname(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{userId}/password") // 비밀번호 수정
    public ResponseEntity<BaseResponse> changePassword(@PathVariable("userId") Long userId,
                                                       @RequestBody PasswordChangeRequestDto request) {
        userValidator.validPassword(request.getPassword());
        BaseResponse response = publicUserService.changePassword(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    /**
     * Delete Mapping
     **/
    @DeleteMapping("/{userId}") // 회원정보 삭제
    public ResponseEntity<BaseResponse> deletePublicUser(@PathVariable("userId") Long userId) {
        BaseResponse response = publicUserService.deleteById(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

}
