package com.roomgenius.furniture_recommendation.entity;


import lombok.Data;

@Data
public class PortOnePaymentDTO {
    private String status;
    private String id;
    private Amount amount;

    @Data
    public static class Amount {
        private Integer total;
    }
}

