package sakhno.springframework.ms_store_two_order_service.dto.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {

}
