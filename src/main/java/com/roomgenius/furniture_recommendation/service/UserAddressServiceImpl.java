package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.UserAddressDTO;
import com.roomgenius.furniture_recommendation.entity.UserAddressVO;
import com.roomgenius.furniture_recommendation.entity.UserVO;
import com.roomgenius.furniture_recommendation.mapper.UserAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAddressServiceImpl implements UserAddressService {

    private final UserAddressMapper addressMapper;

    @Override
    public List<UserAddressDTO> getAddressList(Integer userId) {
        return addressMapper.findByUserId(userId)
                .stream()
                .map(vo -> UserAddressDTO.builder()
                        .addressId(vo.getAddressId())
                        .userId(vo.getUserId())
                        .recipient(vo.getRecipient())
                        .phone(vo.getPhone())
                        .address(vo.getAddress())
                        .detailAddress(vo.getDetailAddress())
                        .isDefault(vo.getIsDefault())
                        .build())
                .toList();
    }

    @Override
    public UserAddressDTO getAddress(Integer addressId) {
        UserAddressVO vo = addressMapper.findById(addressId);
        return UserAddressDTO.builder()
                .addressId(vo.getAddressId())
                .userId(vo.getUserId())
                .recipient(vo.getRecipient())
                .phone(vo.getPhone())
                .address(vo.getAddress())
                .detailAddress(vo.getDetailAddress())
                .isDefault(vo.getIsDefault())
                .build();
    }

    @Override
    public void addAddress(UserAddressDTO dto) {
        UserAddressVO vo = UserAddressVO.builder()
                .userId(dto.getUserId())
                .recipient(dto.getRecipient())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .detailAddress(dto.getDetailAddress())
                .isDefault(dto.getIsDefault())
                .build();

        addressMapper.insertAddress(vo);
    }

    @Override
    @Transactional
    public void updateAddress(UserAddressDTO dto) {

        // 기본 배송지로 설정하면 다른 배송지 먼저 전부 해제
        if (dto.getIsDefault() == 1) {
            addressMapper.resetDefault(dto.getUserId());
        }

        UserAddressVO vo = UserAddressVO.builder()
                .addressId(dto.getAddressId())
                .userId(dto.getUserId())
                .recipient(dto.getRecipient())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .detailAddress(dto.getDetailAddress())
                .isDefault(dto.getIsDefault())  // ★ 추가
                .build();

        addressMapper.updateAddress(vo);
    }


    @Override
    public void deleteAddress(Integer addressId) {
        addressMapper.deleteAddress(addressId);
    }

    @Override
    @Transactional
    public void setDefaultAddress(Integer userId, Integer addressId) {
        addressMapper.resetDefault(userId);
        addressMapper.setDefault(addressId);
    }

    // -----------------------------------------------------
    // 🔥 추가: 기본 배송지가 없으면 user 테이블 주소로 자동 생성
    // -----------------------------------------------------
    @Override
    @Transactional
    public void createDefaultAddressIfNotExists(UserVO user) {

        // user_address 테이블에 아무 주소도 없으면 자동 생성
        List<UserAddressVO> list = addressMapper.findByUserId(user.getUserId());
        if (!list.isEmpty()) {
            return;  // 이미 주소가 있으므로 생성 안 함
        }

        // user.address 자체가 비어있으면 생성 불가
        if (user.getAddress() == null || user.getAddress().isEmpty()) {
            return;
        }

        // 기본 배송지 자동 생성
        UserAddressVO vo = UserAddressVO.builder()
                .userId(user.getUserId())
                .recipient(user.getUserName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .detailAddress("") // 상세주소 없음
                .isDefault(1)
                .build();

        addressMapper.insertAddress(vo);
    }
}
