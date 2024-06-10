package com.josee.payment.payment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMapperTest {

    private PaymentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new PaymentMapper();
    }

    @Test
    void shouldMapPaymentRequestToPayment() {
        PaymentRequest request = PaymentRequest.builder()
                .id(1)
                .amount(BigDecimal.valueOf(500))
                .paymentMethod(PaymentMethod.CREDIT_CARD)
                .orderId(4)
                .build();
        Payment payment = mapper.toPayment(request);

        assertEquals(request.id(), payment.getId());
        assertEquals(request.amount(), payment.getAmount());
        assertEquals(request.paymentMethod(), payment.getPaymentMethod());
        assertEquals(request.orderId(), payment.getOrderId());
    }
}