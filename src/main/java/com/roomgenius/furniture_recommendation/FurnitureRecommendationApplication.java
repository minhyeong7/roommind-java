package com.roomgenius.furniture_recommendation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.roomgenius.furniture_recommendation.mapper")
public class FurnitureRecommendationApplication {
    public static void main(String[] args) {
        SpringApplication.run(FurnitureRecommendationApplication.class, args);
    }
}

