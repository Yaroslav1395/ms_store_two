package sakhno.springframework.ms_store_two_order_service.services.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sakhno.springframework.ms_store_two_order_service.dto.customer.CustomerResponse;

import java.util.Optional;

@FeignClient(name = "MS_STORE_TWO_CUSTOMER_SERVICE", url = "${application.config.customer-url}")
public interface CustomerClient {
    @GetMapping("/{customer-id}")
    Optional<CustomerResponse> findCustomerByIs(@PathVariable("customer-id") String customerId);
}
