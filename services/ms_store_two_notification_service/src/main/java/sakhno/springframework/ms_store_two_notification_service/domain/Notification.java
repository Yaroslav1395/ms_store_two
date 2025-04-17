package sakhno.springframework.ms_store_two_notification_service.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sakhno.springframework.ms_store_two_notification_service.kafka.order.OrderConfirmation;
import sakhno.springframework.ms_store_two_notification_service.kafka.payment.PaymentConfirmation;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
