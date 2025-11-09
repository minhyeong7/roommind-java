package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.dto.request.SignupRequest;
import com.roomgenius.furniture_recommendation.dto.response.MemberResponse;
import com.roomgenius.furniture_recommendation.entity.Member;
import com.roomgenius.furniture_recommendation.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberResponse signup(SignupRequest request) {
        // 1. 이메일 중복 체크
        if (memberMapper.countByEmail(request.getEmail()) > 0) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다");
        }

        // 2. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // 3. Member 엔티티 생성
        Member member = Member.builder()
                .username(request.getUsername())
                .phone(request.getPhone())
                .address(request.getAddress())
                .email(request.getEmail())
                .password(encodedPassword)
                .role("user")
                .build();

        // 4. DB 저장
        memberMapper.insertMember(member);

        // 5. 응답 DTO 생성 (비밀번호 제외)
        return MemberResponse.builder()
                .userId(member.getUserId())
                .username(member.getUsername())
                .phone(member.getPhone())
                .address(member.getAddress())
                .email(member.getEmail())
                .role(member.getRole())
                .createdDate(member.getCreatedDate())
                .build();
    }

    @Override
    public boolean isEmailDuplicate(String email) {
        return memberMapper.countByEmail(email) > 0;
    }

    @Override
    public MemberResponse getMemberById(Integer userId) {
        Member member = memberMapper.findById(userId);
        if (member == null) {
            throw new IllegalArgumentException("회원을 찾을 수 없습니다");
        }

        return MemberResponse.builder()
                .userId(member.getUserId())
                .username(member.getUsername())
                .phone(member.getPhone())
                .address(member.getAddress())
                .email(member.getEmail())
                .role(member.getRole())
                .createdDate(member.getCreatedDate())
                .build();
    }
}