package com.josee.payment.payment;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
