package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.UserDTO;

public interface UserService {

    // 회원가입
    UserDTO signup(UserDTO dto);

    // 회원 조회
    UserDTO getUserById(Integer userId);

    // 로그인
    UserDTO login(UserDTO dto);
}