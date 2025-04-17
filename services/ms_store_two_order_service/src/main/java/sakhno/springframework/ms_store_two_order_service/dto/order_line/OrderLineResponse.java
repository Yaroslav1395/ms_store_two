package sakhno.springframework.ms_store_two_order_service.dto.order_line;

public record OrderLineResponse(
        Integer id,
        double quantity
) { }
