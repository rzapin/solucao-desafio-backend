package com.softexpert.rafael.desafiobackend.integration;

import com.softexpert.rafael.desafiobackend.integration.dto.CobrancaPicPayRequest;
import com.softexpert.rafael.desafiobackend.integration.dto.CobrancaPicPayResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class CobrancaPicPayClient {

    @Value("${picpay.mockurl}")
    private String url;

    @PostMapping("/cobrancaPicPay")
    private ResponseEntity<CobrancaPicPayResponse> cadastraCobrancaPicPay(@RequestHeader("x-picpay-token") String picpayToken,
                                                                          @RequestHeader("x-seller-token") String sellerToken,
                                                                          @RequestBody CobrancaPicPayRequest cobrancaPicPayRequest) {
        RestTemplate cobrancaPicPayRest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("x-picpay-token", picpayToken);
        headers.set("x-seller-token", sellerToken);

        HttpEntity<CobrancaPicPayRequest> request = new HttpEntity<>(cobrancaPicPayRequest, headers);

        return new ResponseEntity<>(cobrancaPicPayRest.postForObject(url, request, CobrancaPicPayResponse.class), HttpStatus.CREATED);
    }
}
