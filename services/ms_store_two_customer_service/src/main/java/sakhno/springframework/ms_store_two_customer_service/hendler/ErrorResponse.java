package sakhno.springframework.ms_store_two_customer_service.hendler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
