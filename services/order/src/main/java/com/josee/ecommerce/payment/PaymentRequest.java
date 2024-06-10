package com.josee.ecommerce.payment;

import com.josee.ecommerce.customer.CustomerResponse;
import com.josee.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
