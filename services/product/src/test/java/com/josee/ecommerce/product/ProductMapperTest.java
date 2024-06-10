package com.josee.ecommerce.product;

import com.josee.ecommerce.category.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {
    private ProductMapper mapper;
    @BeforeEach
    void setUp() {
        mapper = new ProductMapper();
    }

    @Test
    void shouldMapProductRequestToRequest() {
        ProductRequest request = new ProductRequest(
                151,
                "Keyboard K4",
                "This is mechanical keyboard",
                Double.valueOf(10),
                BigDecimal.valueOf(50),
                1
        );
        Product product = mapper.toProduct(request);

        assertEquals(request.id(), product.getId());
        assertEquals(request.name(), product.getName());
        assertEquals(request.description(), product.getDescription());
        assertEquals(request.availableQuantity(), product.getAvailableQuantity());
        assertEquals(request.price(), product.getPrice());
        assertNotNull(product.getCategory());
        assertEquals(request.categoryId(), product.getCategory().getId());
    }

    @Test
    void shouldMapProductToProductResponse() {
        Product product = Product.builder()
                .id(151)
                .name("Keyboard K4")
                .description("This is mechanical keyboard")
                .availableQuantity(Double.valueOf(10))
                .price(BigDecimal.valueOf(50))
                .category(
                        Category.builder()
                                .id(1)
                                .name("Keyboard")
                                .description("Keyboard category")
                                .build()
                )
                .build();
        ProductResponse productResponse = mapper.toProductResponse(product);

        assertEquals(product.getId(), productResponse.id());
        assertEquals(product.getName(), productResponse.name());
        assertEquals(product.getDescription(), productResponse.description());
        assertEquals(product.getAvailableQuantity(), productResponse.availableQuantity());
        assertEquals(product.getPrice(), productResponse.price());
        assertEquals(product.getCategory().getId(), productResponse.categoryId());
        assertEquals(product.getCategory().getName(), productResponse.categoryName());
        assertEquals(product.getCategory().getDescription(), productResponse.categoryDescription());
    }

    @Test
    void shouldMapProductToProductPurchaseResponse() {
        Double quantity = Double.valueOf(2);
        Product product = Product.builder()
                .id(151)
                .name("Keyboard K4")
                .description("This is mechanical keyboard")
                .price(BigDecimal.valueOf(50))
                .build();

        ProductPurchaseResponse response = mapper.toProductPurchaseResponse(product, quantity);
        assertEquals(product.getId(), response.productId());
        assertEquals(product.getName(), response.name());
        assertEquals(product.getDescription(), response.description());
        assertEquals(product.getPrice(), response.price());
        assertEquals(quantity, response.quantity());
    }
}