package com.josee.ecommerce.kafka;

import com.josee.ecommerce.customer.CustomerResponse;
import com.josee.ecommerce.order.PaymentMethod;
import com.josee.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
