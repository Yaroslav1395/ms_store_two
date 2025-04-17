package sakhno.springframework.ms_store_two_order_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sakhno.springframework.ms_store_two_order_service.dto.order.OrderRequest;
import sakhno.springframework.ms_store_two_order_service.dto.order.OrderResponse;
import sakhno.springframework.ms_store_two_order_service.services.order.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<Integer> createOrder(
            @RequestBody @Valid OrderRequest request
    ) {
        return ResponseEntity.ok(this.service.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<OrderResponse> findById(
            @PathVariable("order-id") Integer orderId
    ) {
        return ResponseEntity.ok(this.service.findById(orderId));
    }
}
