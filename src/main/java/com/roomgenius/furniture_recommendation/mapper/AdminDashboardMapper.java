package com.roomgenius.furniture_recommendation.mapper;

import com.roomgenius.furniture_recommendation.entity.CommunityPostVO;
import com.roomgenius.furniture_recommendation.entity.LowStockProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDashboardMapper {

    int getTotalUsers();
    int getTotalProducts();
    int getTotalOrders();
    int getTotalRevenue();

    int getTodayOrders();
    int getTodayRevenue();

    int getPendingQna();

    List<LowStockProductVO> getLowStockProducts();

    int getTotalQna();
    int getTotalCommunityPosts();
    List<CommunityPostVO> getRecentCommunityPosts();

}
