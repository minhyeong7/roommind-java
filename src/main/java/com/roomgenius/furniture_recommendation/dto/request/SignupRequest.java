package com.roomgenius.furniture_recommendation.dto.request;

import lombok.Data;
import jakarta.validation.constraints.Email;      // ← jakarta로 변경!
import jakarta.validation.constraints.NotBlank;   // ← jakarta로 변경!
import jakarta.validation.constraints.Pattern;    // ← jakarta로 변경!

@Data
public class SignupRequest {

    @NotBlank(message = "이름은 필수입니다")
    private String username;

    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다")
    private String phone;

    private String address;

    @NotBlank(message = "이메일은 필수입니다")
    @Email(message = "이메일 형식이 올바르지 않습니다")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "비밀번호는 8자 이상, 영문, 숫자, 특수문자를 포함해야 합니다")
    private String password;
}