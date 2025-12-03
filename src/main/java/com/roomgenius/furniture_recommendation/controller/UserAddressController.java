package com.roomgenius.furniture_recommendation.controller;

import com.roomgenius.furniture_recommendation.entity.UserAddressDTO;
import com.roomgenius.furniture_recommendation.service.UserAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class UserAddressController {

    private final UserAddressService addressService;

    /** 특정 사용자의 배송지 전체 조회 */
    @GetMapping("/{userId}")
    public ResponseEntity<?> getAddresses(@PathVariable Integer userId) {
        List<UserAddressDTO> list = addressService.getAddressList(userId);

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("data", list);

        return ResponseEntity.ok(res);
    }

    /** 배송지 추가 */
    @PostMapping
    public ResponseEntity<?> addAddress(@RequestBody UserAddressDTO dto) {
        addressService.addAddress(dto);

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("message", "배송지가 추가되었습니다.");

        return ResponseEntity.ok(res);
    }

    /** 배송지 수정 */
    @PutMapping
    public ResponseEntity<?> updateAddress(@RequestBody UserAddressDTO dto) {
        addressService.updateAddress(dto);

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("message", "배송지가 수정되었습니다.");

        return ResponseEntity.ok(res);
    }

    /** 배송지 삭제 */
    @DeleteMapping("/{addressId}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer addressId) {
        addressService.deleteAddress(addressId);

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("message", "배송지가 삭제되었습니다.");

        return ResponseEntity.ok(res);
    }

    /** 기본 배송지 설정 */
    @PutMapping("/default")
    public ResponseEntity<?> setDefault(@RequestBody Map<String, Integer> req) {
        Integer userId = req.get("userId");
        Integer addressId = req.get("addressId");

        addressService.setDefaultAddress(userId, addressId);

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("message", "기본 배송지로 설정되었습니다.");

        return ResponseEntity.ok(res);
    }
}
