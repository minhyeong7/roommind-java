package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.MemberDTO;

public interface MemberService {

    // 회원가입
    MemberDTO signup(MemberDTO dto);

    // 이메일 중복 체크
    boolean isEmailDuplicate(String email);

    // 회원 조회
    MemberDTO getMemberById(Integer userId);
}
