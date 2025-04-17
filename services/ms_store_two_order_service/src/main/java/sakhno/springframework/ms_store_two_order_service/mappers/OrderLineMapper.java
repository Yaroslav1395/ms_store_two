package sakhno.springframework.ms_store_two_order_service.mappers;

import org.springframework.stereotype.Service;
import sakhno.springframework.ms_store_two_order_service.dto.order_line.OrderLineRequest;
import sakhno.springframework.ms_store_two_order_service.dto.order_line.OrderLineResponse;
import sakhno.springframework.ms_store_two_order_service.entities.OrderEntity;
import sakhno.springframework.ms_store_two_order_service.entities.OrderLineEntity;

@Service
public class OrderLineMapper {
    public OrderLineEntity toOrderLine(OrderLineRequest request) {
        return OrderLineEntity.builder()
                .id(request.orderId())
                .productId(request.productId())
                .order(
                        OrderEntity.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLineEntity orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
