package sakhno.springframework.ms_store_two_payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sakhno.springframework.ms_store_two_payment_service.enteties.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

}
