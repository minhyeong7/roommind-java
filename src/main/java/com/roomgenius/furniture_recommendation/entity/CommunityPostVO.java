package com.roomgenius.furniture_recommendation.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommunityPostVO {
    private int communityId;
    private String title;
    private int userId;
    private LocalDateTime createdDate;
}