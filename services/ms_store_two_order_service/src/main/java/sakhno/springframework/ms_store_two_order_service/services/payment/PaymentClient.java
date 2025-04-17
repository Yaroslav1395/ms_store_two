package sakhno.springframework.ms_store_two_order_service.services.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sakhno.springframework.ms_store_two_order_service.dto.payment.PaymentRequest;

@FeignClient(name = "MS_STORE_TWO_PRODUCT_SERVICE", url = "${application.config.payment-url}")
public interface PaymentClient {

    @PostMapping
    Integer requestOrderPayment(@RequestBody PaymentRequest paymentRequest);

}
