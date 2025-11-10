package com.roomgenius.furniture_recommendation.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {
    private int userId;                // 회원 고유 ID (PK)
    private String username;           // 사용자 이름
    private String phone;              // 전화번호
    private String address;            // 주소
    private String email;              // 이메일
    private String password;           // 비밀번호
    private String role;               // 역할 (예: USER, ADMIN)
    private LocalDateTime createdDate; // 생성일
    private LocalDateTime updatedDate; // 수정일
}

