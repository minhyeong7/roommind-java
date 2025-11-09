package com.roomgenius.furniture_recommendation.mapper;

import com.roomgenius.furniture_recommendation.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    // 회원가입
    int insertMember(Member member);

    // 이메일 중복 체크
    int countByEmail(@Param("email") String email);

    // 이메일로 회원 조회
    Member findByEmail(@Param("email") String email);

    // ID로 회원 조회
    Member findById(@Param("userId") Integer userId);
}