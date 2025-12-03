package com.roomgenius.furniture_recommendation.mapper;

import com.roomgenius.furniture_recommendation.entity.UserAddressVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAddressMapper {

    List<UserAddressVO> findByUserId(@Param("userId") Integer userId);

    UserAddressVO findById(@Param("addressId") Integer addressId);

    int insertAddress(UserAddressVO vo);

    int updateAddress(UserAddressVO vo);

    int deleteAddress(@Param("addressId") Integer addressId);

    void resetDefault(@Param("userId") Integer userId);

    void setDefault(@Param("addressId") Integer addressId);

    UserAddressVO findDefaultByUserId(@Param("userId") Integer userId);

}
