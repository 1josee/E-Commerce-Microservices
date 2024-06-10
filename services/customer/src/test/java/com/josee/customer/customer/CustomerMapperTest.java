package com.josee.customer.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    private CustomerMapper mapper;
    @BeforeEach
    void setUp() {
        mapper = new CustomerMapper();
    }

    @Test
    public void shouldMapCustomerRequestToCustomer() {
        CustomerRequest request = new CustomerRequest(
                "s12345",
                "Tien",
                "Tran",
                "trannhattien@gmail.com",
                new Address(
                        "7A",
                        "3",
                        "700000"
                )
        );
        Customer customer = mapper.toCustomer(request);

        assertEquals(request.id(), customer.getId());
        assertEquals(request.firstname(), customer.getFirstname());
        assertEquals(request.lastname(), customer.getLastname());
        assertEquals(request.email(), customer.getEmail());
        assertNotNull(customer.getAddress());
        assertEquals(request.address().getStreet(), customer.getAddress().getStreet());
        assertEquals(request.address().getHouseNumber(), customer.getAddress().getHouseNumber());
        assertEquals(request.address().getZipCode(), customer.getAddress().getZipCode());
    }

    @Test
    public void shouldMapCustomerToCustomerResponse() {
        Customer customer = new Customer(
                "s12345",
                "Tien",
                "Tran",
                "trannhattien@gmail.com",
                new Address(
                        "7A",
                        "3",
                        "700000"
                )
        );
        CustomerResponse customerResponse = mapper.fromCustomer(customer);
        assertEquals(customer.getId(), customerResponse.id());
        assertEquals(customer.getFirstname(), customerResponse.firstname());
        assertEquals(customer.getLastname(), customerResponse.lastname());
        assertEquals(customer.getEmail(), customerResponse.email());
        assertNotNull(customerResponse.address());
        assertEquals(customer.getAddress().getStreet(), customerResponse.address().getStreet());
        assertEquals(customer.getAddress().getHouseNumber(), customerResponse.address().getHouseNumber());
        assertEquals(customer.getAddress().getZipCode(), customerResponse.address().getZipCode());
    }
}