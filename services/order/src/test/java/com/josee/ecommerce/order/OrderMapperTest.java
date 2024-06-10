package com.josee.ecommerce.order;

import com.josee.ecommerce.product.PurchaseRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {
    private OrderMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new OrderMapper();
    }

    @Test
    public void shouldMapOrderRequestToOrder() {
        OrderRequest request = OrderRequest.builder()
                .id(1)
                .reference("MS_20240501")
                .amount(BigDecimal.valueOf(600))
                .paymentMethod(PaymentMethod.CREDIT_CARD)
                .customerId("s1234567")
                .build();
        Order order = mapper.toOrder(request);
        assertEquals(request.id(), order.getId());
        assertEquals(request.reference(), order.getReference());
        assertEquals(request.amount(), order.getTotalAmount());
        assertEquals(request.paymentMethod(), order.getPaymentMethod());
        assertEquals(request.customerId(), order.getCustomerId());

    }

    @Test
    public void shouldMapOrderToOrderResponse() {
        Order order = Order.builder()
                .id(1)
                .reference("MS_20240501")
                .totalAmount(BigDecimal.valueOf(600))
                .paymentMethod(PaymentMethod.CREDIT_CARD)
                .customerId("s1234567")
                .build();
        OrderResponse orderResponse = mapper.fromOrder(order);
        assertEquals(order.getId(), orderResponse.id());
        assertEquals(order.getReference(), orderResponse.reference());
        assertEquals(order.getTotalAmount(), orderResponse.amount());
        assertEquals(order.getPaymentMethod(), orderResponse.paymentMethod());
        assertEquals(order.getCustomerId(), orderResponse.customerId());
    }
}