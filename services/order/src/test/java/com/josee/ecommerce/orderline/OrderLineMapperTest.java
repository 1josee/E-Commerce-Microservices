package com.josee.ecommerce.orderline;

import com.josee.ecommerce.order.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineMapperTest {

    private OrderLineMapper mapper;
    @BeforeEach
    void setUp() {
        mapper = new OrderLineMapper();
    }

    @Test
    void shouldMapOrderLineRequestToOrderLine() {
        OrderLineRequest request = new OrderLineRequest(
                2,
                3,
                51,
                Double.valueOf(1)
        );
        OrderLine orderLine = mapper.toOrderLine(request);

        assertEquals(request.id(), orderLine.getId());
        assertNotNull(orderLine.getOrder());
        assertEquals(request.orderId(), orderLine.getOrder().getId());
        assertEquals(request.productId(), orderLine.getProductId());
        assertEquals(request.quantity(), orderLine.getQuantity());
    }

    @Test
    void shouldMapOrderLineToOrderLineResponse() {
        OrderLine orderLine = OrderLine.builder()
                .id(2)
                .order(
                        Order.builder()
                                .id(3)
                                .build()
                )
                .productId(51)
                .quantity(Double.valueOf(1))
                .build();
        OrderLineResponse orderLineResponse = mapper.toOrderLineResponse(orderLine);

        assertEquals(orderLine.getId(), orderLineResponse.id());
        assertEquals(orderLine.getQuantity(), orderLineResponse.quantity());
    }
}