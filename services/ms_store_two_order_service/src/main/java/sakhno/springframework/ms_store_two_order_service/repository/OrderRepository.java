package sakhno.springframework.ms_store_two_order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sakhno.springframework.ms_store_two_order_service.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
