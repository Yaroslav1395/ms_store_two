package sakhno.springframework.ms_store_two_order_service.kafka;

import org.apache.kafka.common.protocol.types.Field;
import sakhno.springframework.ms_store_two_order_service.dto.customer.CustomerResponse;
import sakhno.springframework.ms_store_two_order_service.dto.product.PurchaseResponse;
import sakhno.springframework.ms_store_two_order_service.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customerResponse,
        List<PurchaseResponse> purchaseResponses
) {

}
