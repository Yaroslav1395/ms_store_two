package sakhno.springframework.ms_store_two_payment_service.dto;

import sakhno.springframework.ms_store_two_payment_service.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest (
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
