package com.roomgenius.furniture_recommendation.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddressDTO {

    private Integer addressId;
    private Integer userId;
    private String recipient;
    private String phone;
    private String address;
    private String detailAddress;
    private Integer isDefault;

}
