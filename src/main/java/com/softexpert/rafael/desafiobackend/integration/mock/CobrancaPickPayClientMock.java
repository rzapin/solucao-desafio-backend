package com.softexpert.rafael.desafiobackend.integration.mock;

import com.softexpert.rafael.desafiobackend.integration.dto.CobrancaPicPayRequest;
import com.softexpert.rafael.desafiobackend.integration.dto.CobrancaPicPayResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce/public")
public class CobrancaPickPayClientMock {

    @PostMapping("/paymentMock")
    private ResponseEntity<CobrancaPicPayResponse> cobrancaPicPayMock(@RequestHeader("x-picpay-token") String picpayToken,
                                                                      @RequestHeader("x-seller-token") String sellerToken,
                                                                      @RequestBody CobrancaPicPayRequest cobrancaPicPayRequest) {

        String paymentUrl = "https://app.picpay.com/checkout/"
                + cobrancaPicPayRequest.getReferenceId()
                + cobrancaPicPayRequest.getBuyer().getDocument()
                + cobrancaPicPayRequest.getValue();

        CobrancaPicPayResponse picPayResponse = new CobrancaPicPayResponse(cobrancaPicPayRequest.getReferenceId(), paymentUrl, "2040-05-01T16:00:00-03:00");
        return new ResponseEntity<>(picPayResponse, HttpStatus.CREATED);
    }
}
