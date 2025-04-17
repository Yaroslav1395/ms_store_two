package sakhno.springframework.ms_store_two_payment_service.mappers;

import org.springframework.stereotype.Service;
import sakhno.springframework.ms_store_two_payment_service.dto.PaymentRequest;
import sakhno.springframework.ms_store_two_payment_service.enteties.PaymentEntity;

@Service
public class PaymentMapper {

    public PaymentEntity toPayment(PaymentRequest request) {
        if (request == null) {
            return null;
        }
        return PaymentEntity.builder()
                .id(request.id())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .orderId(request.orderId())
                .build();
    }
}
