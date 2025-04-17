package sakhno.springframework.ms_store_two_order_service.dto.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import sakhno.springframework.ms_store_two_order_service.dto.product.PurchaseRequest;
import sakhno.springframework.ms_store_two_order_service.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message = "Order amount should be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method should be precised")
        PaymentMethod paymentMethod,
        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        String customerId,
        @NotEmpty(message = "You should at least purchase one product")
        List<PurchaseRequest> products
) {

}
