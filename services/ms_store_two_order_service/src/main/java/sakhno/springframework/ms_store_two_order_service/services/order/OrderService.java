package sakhno.springframework.ms_store_two_order_service.services.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sakhno.springframework.ms_store_two_order_service.dto.order.OrderRequest;
import sakhno.springframework.ms_store_two_order_service.dto.order.OrderResponse;
import sakhno.springframework.ms_store_two_order_service.dto.order_line.OrderLineRequest;
import sakhno.springframework.ms_store_two_order_service.dto.payment.PaymentRequest;
import sakhno.springframework.ms_store_two_order_service.dto.product.PurchaseRequest;
import sakhno.springframework.ms_store_two_order_service.dto.product.PurchaseResponse;
import sakhno.springframework.ms_store_two_order_service.exceptions.BusinessException;
import sakhno.springframework.ms_store_two_order_service.kafka.OrderConfirmation;
import sakhno.springframework.ms_store_two_order_service.kafka.OrderProducer;
import sakhno.springframework.ms_store_two_order_service.mappers.OrderMapper;
import sakhno.springframework.ms_store_two_order_service.repository.OrderRepository;
import sakhno.springframework.ms_store_two_order_service.services.customer.CustomerClient;
import sakhno.springframework.ms_store_two_order_service.services.order_line.OrderLineService;
import sakhno.springframework.ms_store_two_order_service.services.payment.PaymentClient;
import sakhno.springframework.ms_store_two_order_service.services.product.ProductClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest orderRequest) {
        var customer = customerClient.findCustomerByIs(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException(
                        "Cannot create order:: No Customer exists with the provided ID:" + orderRequest.customerId()));
        List<PurchaseResponse> purchases = productClient.purchaseProducts(orderRequest.products());
        var order = orderRepository.save(orderMapper.toOrder(orderRequest));
        for(PurchaseRequest purchaseRequest : orderRequest.products()) {
            orderLineService.saveOrderLine(new OrderLineRequest(
                    null, order.getId(), purchaseRequest.productId(), purchaseRequest.quantity()));
        }

        var paymentRequest = new PaymentRequest(orderRequest.amount(), orderRequest.paymentMethod(), order.getId(),
                orderRequest.reference(), customer);
        paymentClient.requestOrderPayment(paymentRequest);

        orderProducer.orderConfirmation(new OrderConfirmation(
                orderRequest.reference(), orderRequest.amount(), orderRequest.paymentMethod(), customer, purchases));
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new BusinessException("Cannot find order with the provided ID:" + orderId));
    }
}
