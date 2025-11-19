package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.config.JwtTokenProvider;
import com.roomgenius.furniture_recommendation.entity.UserDTO;
import com.roomgenius.furniture_recommendation.entity.UserVO;
import com.roomgenius.furniture_recommendation.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입
    @Override
    @Transactional
    public UserDTO signup(UserDTO dto) {
        // 1. 이메일 중복 체크
        if (userMapper.countByEmail(dto.getEmail()) > 0) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다");
        }

        // 2. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        // 3. User 엔티티 생성
        UserVO user = UserVO.builder()
                .userName(dto.getUserName())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .password(encodedPassword)
                .role("user")
                .build();

        // 4. DB 저장
        userMapper.insertUser(user);

        // 5. DTO로 변환 후 반환 (비밀번호 제외)
        return UserDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .email(user.getEmail())
                .role(user.getRole())
                .createdDate(user.getCreatedDate())
                .build();
    }

    // 로그인
    @Override
    @Transactional(readOnly = true)
    public UserDTO login(UserDTO dto) {
        // 1. 이메일로 회원 조회
        UserVO user = userMapper.findByEmail(dto.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다");
        }

        // 2. 비밀번호 검증
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다");
        }

        // 3. JWT 토큰 생성
        String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRole());

        // 4. 로그인 응답 DTO 생성 (비밀번호 제외)
        return UserDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .message("로그인 성공")
                .build();
    }

    // 회원 1명 조회
    @Override
    public UserDTO getUserById(Integer userId) {
        UserVO user = userMapper.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("회원을 찾을 수 없습니다");
        }

        return UserDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .email(user.getEmail())
                .role(user.getRole())
                .createdDate(user.getCreatedDate())
                .updateDate(user.getUpdatedDate())
                .build();
    }
}