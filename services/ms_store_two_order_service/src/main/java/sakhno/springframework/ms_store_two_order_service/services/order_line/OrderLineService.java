package sakhno.springframework.ms_store_two_order_service.services.order_line;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sakhno.springframework.ms_store_two_order_service.dto.order_line.OrderLineRequest;
import sakhno.springframework.ms_store_two_order_service.dto.order_line.OrderLineResponse;
import sakhno.springframework.ms_store_two_order_service.entities.OrderLineEntity;
import sakhno.springframework.ms_store_two_order_service.mappers.OrderLineMapper;
import sakhno.springframework.ms_store_two_order_service.repository.OrderLineRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = orderLineMapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId).stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
