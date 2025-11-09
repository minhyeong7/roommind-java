package com.roomgenius.furniture_recommendation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private Integer userId;
    private String username;
    private String phone;
    private String address;
    private String email;
    private String role;
    private LocalDateTime createdDate;
    // 비밀번호는 응답에 포함하지 않음!
}