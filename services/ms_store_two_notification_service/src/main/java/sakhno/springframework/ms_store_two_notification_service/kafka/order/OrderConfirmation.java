package sakhno.springframework.ms_store_two_notification_service.kafka.order;

import sakhno.springframework.ms_store_two_notification_service.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products

) {
}
