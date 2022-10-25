package com.softexpert.rafael.desafiobackend.integration.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CobrancaPicPayRequest {

    private String referenceId;

    private String callbackUrl;

    private Double value;

    private PicPayBuyer buyer;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public PicPayBuyer getBuyer() {
        return buyer;
    }

    public void setBuyer(PicPayBuyer buyer) {
        this.buyer = buyer;
    }
}
