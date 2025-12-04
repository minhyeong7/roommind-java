package com.roomgenius.furniture_recommendation.entity;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddressVO {

    private Integer addressId;
    private Integer userId;
    private String recipient;
    private String phone;
    private String address;
    private String detailAddress;
    private Integer isDefault;
    private Timestamp createdDate;
}
