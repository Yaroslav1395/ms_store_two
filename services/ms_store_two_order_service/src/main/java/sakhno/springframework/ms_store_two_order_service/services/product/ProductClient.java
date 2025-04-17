package sakhno.springframework.ms_store_two_order_service.services.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sakhno.springframework.ms_store_two_order_service.dto.product.PurchaseRequest;
import sakhno.springframework.ms_store_two_order_service.dto.product.PurchaseResponse;
import sakhno.springframework.ms_store_two_order_service.exceptions.BusinessException;

import java.util.List;

import static org.apache.http.protocol.HTTP.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class ProductClient {
    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requestBody) {
        HttpHeaders headers =  new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequest>> request = new HttpEntity<>(requestBody, headers);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<PurchaseResponse>> response = restTemplate.exchange(
                productUrl + "/purchase", POST, request, responseType);
        if(response.getStatusCode().isError())
            throw new BusinessException("An error occurred while processing the products purchase" + response.getStatusCode());
        return response.getBody();
    }
}
