package sakhno.springframework.ms_store_two_notification_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sakhno.springframework.ms_store_two_notification_service.domain.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
