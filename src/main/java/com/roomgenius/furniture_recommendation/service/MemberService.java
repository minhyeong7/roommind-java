package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.dto.request.SignupRequest;
import com.roomgenius.furniture_recommendation.dto.response.MemberResponse;

public interface MemberService {

    // 회원가입
    MemberResponse signup(SignupRequest request);

    // 이메일 중복 체크
    boolean isEmailDuplicate(String email);

    // 회원 조회
    MemberResponse getMemberById(Integer userId);
}