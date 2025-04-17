package sakhno.springframework.ms_store_two_product_service.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
