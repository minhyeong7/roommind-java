package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.config.JwtTokenProvider;
import com.roomgenius.furniture_recommendation.entity.MemberDTO;
import com.roomgenius.furniture_recommendation.entity.MemberVO;
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
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입
    @Override
    @Transactional
    public MemberDTO signup(MemberDTO dto) {
        // 1. 이메일 중복 체크
        if (memberMapper.countByEmail(dto.getEmail()) > 0) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다");
        }

        // 2. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        // 3. Member 엔티티 생성
        MemberVO member = MemberVO.builder()
                .username(dto.getUsername())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .password(encodedPassword)
                .role("user")
                .build();

        // 4. DB 저장
        memberMapper.insertMember(member);

        // 5. DTO로 변환 후 반환 (비밀번호 제외)
        return MemberDTO.builder()
                .userId(member.getUserId())
                .username(member.getUsername())
                .phone(member.getPhone())
                .address(member.getAddress())
                .email(member.getEmail())
                .role(member.getRole())
                .createdDate(member.getCreatedDate())
                .build();
    }

    // 로그인
    @Override
    @Transactional(readOnly = true)
    public MemberDTO login(MemberDTO dto) {
        // 1. 이메일로 회원 조회
        MemberVO member = memberMapper.findByEmail(dto.getEmail());
        if (member == null) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다");
        }

        // 2. 비밀번호 검증
        if (!passwordEncoder.matches(dto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다");
        }

        // 3. JWT 토큰 생성
        String token = jwtTokenProvider.generateToken(member.getEmail(), member.getRole());

        // 4. 로그인 응답 DTO 생성 (비밀번호 제외)
        return MemberDTO.builder()
                .userId(member.getUserId())
                .username(member.getUsername())
                .email(member.getEmail())
                .role(member.getRole())
                .token(token)
                .message("로그인 성공")
                .build();
    }

    // 회원 1명 조회
    @Override
    public MemberDTO getMemberById(Integer userId) {
        MemberVO member = memberMapper.findById(userId);
        if (member == null) {
            throw new IllegalArgumentException("회원을 찾을 수 없습니다");
        }

        return MemberDTO.builder()
                .userId(member.getUserId())
                .username(member.getUsername())
                .phone(member.getPhone())
                .address(member.getAddress())
                .email(member.getEmail())
                .role(member.getRole())
                .createdDate(member.getCreatedDate())
                .updateDate(member.getUpdatedDate())
                .build();
    }
}