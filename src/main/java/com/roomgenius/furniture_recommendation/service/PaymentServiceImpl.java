package com.roomgenius.furniture_recommendation.service;

import com.roomgenius.furniture_recommendation.entity.PortOnePaymentDTO;
import com.roomgenius.furniture_recommendation.entity.*;
import com.roomgenius.furniture_recommendation.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final OrderMapper orderMapper;

    @Value("${portone.store-id}")
    private String storeId;

    @Value("${portone.secret}")
    private String secret;

    private static final String PORTONE_BASE_URL = "https://api.portone.io";

    @Override
    @Transactional
    public OrderDTO confirmPayment(Integer userId, PaymentConfirmDTO dto) {

        // 1) 주문 조회
        OrderVO order = orderMapper.selectOrderById(dto.getOrderId());
        if (order == null) {
            throw new IllegalArgumentException("존재하지 않는 주문입니다.");
        }
        if (!order.getUserId().equals(userId)) {
            throw new IllegalStateException("본인 주문만 결제할 수 있습니다.");
        }

        // 2) PortOne 결제 검증
        RestTemplate restTemplate = new RestTemplate();
        String url = PORTONE_BASE_URL + "/payments/" + dto.getPaymentId()
                + "?storeId=" + storeId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "PortOne " + secret);
        headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        // JSON 원본 출력
        String raw = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        System.out.println("====== PortOne RAW JSON ======");
        System.out.println(raw);

        ResponseEntity<PortOnePaymentDTO> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, PortOnePaymentDTO.class);

        PortOnePaymentDTO payment = response.getBody();
        if (payment == null) {
            throw new IllegalStateException("포트원 응답이 비어 있습니다.");
        }

        // 금액 검증
        if (!payment.getAmount().getTotal().equals(order.getTotalPrice())) {
            throw new IllegalStateException("결제 금액이 주문 금액과 일치하지 않습니다.");
        }

        // 상태 검증
        if (!"PAID".equalsIgnoreCase(payment.getStatus())) {
            throw new IllegalStateException("결제가 완료 상태가 아닙니다. status=" + payment.getStatus());
        }

        // 3) 주문 상태 업데이트
        orderMapper.updateOrderStatus(order.getOrderId(), "PAID");

        // ⭐ 4) 주문 상품 불러와서 재고 감소
        List<OrderItemDTO> items = orderMapper.selectOrderItems(order.getOrderId());

        for (OrderItemDTO item : items) {
            int updated = orderMapper.decreaseStock(item.getProductId(), item.getQuantity());
            if (updated == 0) {
                throw new IllegalStateException("재고 부족 상품 존재: productId=" + item.getProductId());
            }
        }

        // 5) 응답 DTO 반환
        OrderDTO result = new OrderDTO();
        result.setOrderId(order.getOrderId());
        result.setDeliveryAddress(order.getDeliveryAddress());
        result.setTotalPrice(order.getTotalPrice());
        result.setStatus("PAID");

        return result;
    }
}
