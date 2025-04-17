package sakhno.springframework.ms_store_two_order_service.mappers;

import org.springframework.stereotype.Service;
import sakhno.springframework.ms_store_two_order_service.dto.order.OrderRequest;
import sakhno.springframework.ms_store_two_order_service.dto.order.OrderResponse;
import sakhno.springframework.ms_store_two_order_service.entities.OrderEntity;

@Service
public class OrderMapper {


    public OrderEntity toOrder(OrderRequest request) {
        if (request == null) {
            return null;
        }
        return OrderEntity.builder()
                .id(request.id())
                .reference(request.reference())
                .paymentMethod(request.paymentMethod())
                .customerId(request.customerId())
                .build();
    }

    public OrderResponse fromOrder(OrderEntity order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
