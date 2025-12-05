package com.roomgenius.furniture_recommendation.controller;

import com.roomgenius.furniture_recommendation.entity.DashboardDTO;
import com.roomgenius.furniture_recommendation.service.AdminDashboardService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminDashboardController {

    private final AdminDashboardService dashboardService;

    // 관리자 대시보드 데이터 전체 조회
    @GetMapping("/dashboard")
    public ResponseEntity<DashboardDTO> getDashboardData() {
        DashboardDTO data = dashboardService.getDashboardStats();
        return ResponseEntity.ok(data);
    }
}
