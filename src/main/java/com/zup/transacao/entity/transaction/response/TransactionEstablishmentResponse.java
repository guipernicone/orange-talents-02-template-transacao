package com.zup.transacao.entity.transaction.response;

import com.zup.transacao.entity.transaction.TransactionEstablishment;

import javax.validation.constraints.NotBlank;

public class TransactionEstablishmentResponse {

    private String name;
    private String city;
    private String address;

    public TransactionEstablishmentResponse(TransactionEstablishment transactionEstablishment) {
        this.name = transactionEstablishment.getName();
        this.city = transactionEstablishment.getCity();
        this.address = transactionEstablishment.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
