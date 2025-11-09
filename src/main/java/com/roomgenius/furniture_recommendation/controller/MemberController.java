package com.roomgenius.furniture_recommendation.controller;

import com.roomgenius.furniture_recommendation.dto.request.SignupRequest;
import com.roomgenius.furniture_recommendation.dto.response.MemberResponse;
import com.roomgenius.furniture_recommendation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;  //
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Validated
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@Valid @RequestBody SignupRequest request) {
        try {
            MemberResponse response = memberService.signup(request);

            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "회원가입이 완료되었습니다");
            result.put("data", response);

            return ResponseEntity.status(HttpStatus.CREATED).body(result);

        } catch (IllegalArgumentException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/check-email")
    public ResponseEntity<Map<String, Object>> checkEmail(@RequestParam String email) {
        boolean isDuplicate = memberService.isEmailDuplicate(email);

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("isDuplicate", isDuplicate);
        result.put("message", isDuplicate ? "이미 사용 중인 이메일입니다" : "사용 가능한 이메일입니다");

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> getMember(@PathVariable Integer userId) {
        try {
            MemberResponse response = memberService.getMemberById(userId);

            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("data", response);

            return ResponseEntity.ok(result);

        } catch (IllegalArgumentException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }
}