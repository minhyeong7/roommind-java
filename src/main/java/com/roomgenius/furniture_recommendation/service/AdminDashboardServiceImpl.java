package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.DashboardDTO;
import com.roomgenius.furniture_recommendation.mapper.AdminDashboardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminDashboardServiceImpl implements AdminDashboardService {

    private final AdminDashboardMapper mapper;

    @Override
    public DashboardDTO getDashboardStats() {
        DashboardDTO dto = new DashboardDTO();

        dto.setTotalUsers(mapper.getTotalUsers());
        dto.setTotalProducts(mapper.getTotalProducts());
        dto.setTotalOrders(mapper.getTotalOrders());
        dto.setTotalRevenue(mapper.getTotalRevenue());

        dto.setTodayOrders(mapper.getTodayOrders());
        dto.setTodayRevenue(mapper.getTodayRevenue());

        dto.setPendingQna(mapper.getPendingQna());
        dto.setLowStockProducts(mapper.getLowStockProducts());

        dto.setTotalQna(mapper.getTotalQna());
        dto.setTotalCommunityPosts(mapper.getTotalCommunityPosts());
        dto.setRecentCommunityPosts(mapper.getRecentCommunityPosts());


        return dto;
    }
}
