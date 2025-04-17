package sakhno.springframework.ms_store_two_order_service.dto.order_line;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productId,
        double quantity
) {
}
