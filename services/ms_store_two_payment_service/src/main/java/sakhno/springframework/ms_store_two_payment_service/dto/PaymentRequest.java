package sakhno.springframework.ms_store_two_payment_service.dto;

import sakhno.springframework.ms_store_two_payment_service.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}