package sakhno.springframework.ms_store_two_order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sakhno.springframework.ms_store_two_order_service.entities.OrderLineEntity;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer> {

    List<OrderLineEntity> findAllByOrderId(Integer orderId);
}
