package sakhno.springframework.ms_store_two_order_service.dto.payment;

import sakhno.springframework.ms_store_two_order_service.dto.customer.CustomerResponse;
import sakhno.springframework.ms_store_two_order_service.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest (
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
