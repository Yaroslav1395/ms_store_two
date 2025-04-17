package sakhno.springframework.ms_store_two_customer_service.dto;

import sakhno.springframework.ms_store_two_customer_service.customer.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {

}
