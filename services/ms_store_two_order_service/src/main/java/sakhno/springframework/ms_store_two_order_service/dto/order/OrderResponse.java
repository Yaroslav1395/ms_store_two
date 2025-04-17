package sakhno.springframework.ms_store_two_order_service.dto.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import sakhno.springframework.ms_store_two_order_service.enums.PaymentMethod;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) {

}
