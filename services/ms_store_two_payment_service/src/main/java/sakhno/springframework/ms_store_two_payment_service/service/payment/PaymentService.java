package sakhno.springframework.ms_store_two_payment_service.service.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sakhno.springframework.ms_store_two_payment_service.dto.PaymentNotificationRequest;
import sakhno.springframework.ms_store_two_payment_service.dto.PaymentRequest;
import sakhno.springframework.ms_store_two_payment_service.mappers.PaymentMapper;
import sakhno.springframework.ms_store_two_payment_service.repository.PaymentRepository;
import sakhno.springframework.ms_store_two_payment_service.service.notification.NotificationProducer;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;


    public Integer createPayment(PaymentRequest request) {
        var payment = paymentRepository.save(paymentMapper.toPayment(request));
        notificationProducer.sendNotification(new PaymentNotificationRequest(request.orderReference(), request.amount(),
                request.paymentMethod(), request.customer().firstname(), request.customer().lastname(), request.customer().email()));
        return payment.getId();
    }
}
