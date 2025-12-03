package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.UserAddressDTO;
import com.roomgenius.furniture_recommendation.entity.UserVO;

import java.util.List;

public interface UserAddressService {

    List<UserAddressDTO> getAddressList(Integer userId);

    UserAddressDTO getAddress(Integer addressId);

    void addAddress(UserAddressDTO dto);

    void updateAddress(UserAddressDTO dto);

    void deleteAddress(Integer addressId);

    void setDefaultAddress(Integer userId, Integer addressId);

    void createDefaultAddressIfNotExists(UserVO user);

}
