package com.project.aminutesociety.user.controller;

import com.project.aminutesociety.user.dto.ChangeTimeDto;
import com.project.aminutesociety.user.dto.UserLoginRequestDto;
import com.project.aminutesociety.user.dto.UserSignUpDto;
import com.project.aminutesociety.user.service.UserService;
import com.project.aminutesociety.util.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "User", description = "유저 관련 API")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @Operation(summary = "회원 가입")
    @PostMapping("/signup")
    public ResponseEntity<CustomApiResponse<?>> signUp(@RequestBody UserSignUpDto.Req req) {
        ResponseEntity<CustomApiResponse<?>> result = userService.signUp(req);
        return result;
    }

    // 로그인
    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<CustomApiResponse<?>> login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        ResponseEntity<CustomApiResponse<?>> result = userService.login(userLoginRequestDto);
        return result;
    }

    // userId 존재 확인
    @Operation(summary = "userId로 유저 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<CustomApiResponse<?>> checkUserId(@PathVariable String userId) {
        ResponseEntity<CustomApiResponse<?>> result = userService.checkUserId(userId);
        return result;
    }

    // 설정된 카테고리 확인 및 유저 정보 추가 응답 필요
    @Operation(summary = "유저의 관심분야 조회")
    @GetMapping("/{userId}/user-info")
    public ResponseEntity<CustomApiResponse<?>> userInfo(@PathVariable String userId) {
        ResponseEntity<CustomApiResponse<?>> result = userService.userInfo(userId);
        return result;
    }

    // 소요시간 변경
    @Operation(summary = "유저의 소요시간 변경")
    @PutMapping("/{userId}/change-time")
    public ResponseEntity<CustomApiResponse<?>> changeTime(@PathVariable String userId, @RequestBody ChangeTimeDto changeTimeDto) {
        ResponseEntity<CustomApiResponse<?>> result = userService.changeTime(userId, changeTimeDto);
        return result;
    }

    // 회원 탈퇴
    @Operation(summary = "회원 탈퇴")
    @DeleteMapping("/{userId}/signout")
    public ResponseEntity<CustomApiResponse<?>> logout(@PathVariable String userId) {
        ResponseEntity<CustomApiResponse<?>> result = userService.SignOut(userId);
        return result;
    }

}
