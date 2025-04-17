package sakhno.springframework.ms_store_two_notification_service.kafka.order;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {

}
