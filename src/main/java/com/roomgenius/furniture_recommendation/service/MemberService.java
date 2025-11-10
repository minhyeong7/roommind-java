package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.MemberDTO;

public interface MemberService {

    // 회원가입
    MemberDTO signup(MemberDTO dto);

    // 회원 조회
    MemberDTO getMemberById(Integer userId);

    // 로그인
    MemberDTO login(MemberDTO dto);
}