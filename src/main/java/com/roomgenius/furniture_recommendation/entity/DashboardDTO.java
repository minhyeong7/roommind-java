package com.roomgenius.furniture_recommendation.entity;

import com.roomgenius.furniture_recommendation.entity.LowStockProductVO;
import lombok.Data;

import java.util.List;

@Data
public class DashboardDTO {

    private int totalUsers;        // 총 회원수
    private int totalProducts;     // 총 상품수
    private int totalOrders;       // 총 주문수
    private int totalRevenue;      // 총 매출액

    private int todayOrders;       // 오늘 주문수
    private int todayRevenue;      // 오늘 매출액

    private int pendingQna;        // 미답변 Q&A 개수

    private List<LowStockProductVO> lowStockProducts;  // 재고 부족 상품 목록

    private int totalQna;
    private int totalCommunityPosts;
    private List<CommunityPostVO> recentCommunityPosts;

}
