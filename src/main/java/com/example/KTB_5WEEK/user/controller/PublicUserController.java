package com.example.KTB_5WEEK.user.controller;

import com.example.KTB_5WEEK.swagger.controller.user.UserApiDoc;
import com.example.KTB_5WEEK.app.response.BaseResponse;
import com.example.KTB_5WEEK.user.service.PublicUserService;
import com.example.KTB_5WEEK.user.dto.request.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class PublicUserController implements UserApiDoc {

    private final PublicUserService publicUserService;

    public PublicUserController(PublicUserService publicUserService) {
        this.publicUserService = publicUserService;
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
    public ResponseEntity<BaseResponse> createPublicUser(@RequestBody @Valid RegistUserRequestDto request) {
        BaseResponse response = publicUserService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/nickname/double-check") // 닉네입 중복 확인
    public ResponseEntity<BaseResponse> doubleCheckNickname(@RequestBody CheckNicknameAvailabilityRequestDto request) {
        BaseResponse response = publicUserService.doubleCheckNickname(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/email/double-check") // 이메일 중복 확인
    public ResponseEntity<BaseResponse> doubleCheckEmail(@RequestBody CheckEmailAvailabilityRequestDto request) {
        BaseResponse response = publicUserService.doubleCheckEmail(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{userId}/password") // 비밀번호 수정
    public ResponseEntity<BaseResponse> changePassword(@PathVariable("userId") Long userId,
                                                      @RequestBody PasswordChangeRequestDto request) {
        BaseResponse response = publicUserService.changePassword(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Patch Mapping
     **/
    @PatchMapping("/{userId}/nickname") // 닉네임 수정
    public ResponseEntity<BaseResponse> editNickName(@PathVariable("userId") Long userId,
                                                     @RequestBody NicknameEditRequestDto request) {
        BaseResponse response = publicUserService.editNickname(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    /**
     * Delete Mapping
     **/
    @DeleteMapping("/{userId}") // 회원정보 삭제
    public ResponseEntity<BaseResponse> deletePublicUser(Long userId) {
        BaseResponse response = publicUserService.deleteById(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

}