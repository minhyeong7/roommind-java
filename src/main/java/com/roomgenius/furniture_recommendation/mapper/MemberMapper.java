package com.roomgenius.furniture_recommendation.mapper;

import com.roomgenius.furniture_recommendation.entity.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    // 회원가입
    int insertMember(MemberVO member);

    // 이메일 중복 체크
    int countByEmail(@Param("email") String email);

    // ID로 회원 조회
    MemberVO findById(@Param("userId") Integer userId);

    // 이메일로 회원 조회 (로그인용) ← 추가
    MemberVO findByEmail(@Param("email") String email);
}