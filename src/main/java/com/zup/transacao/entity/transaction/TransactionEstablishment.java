package com.zup.transacao.entity.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class TransactionEstablishment {

    @NotBlank
    private String name;

    @NotBlank
    private String city;

    @NotBlank
    private String address;

    @Deprecated
    public TransactionEstablishment() {}

    public TransactionEstablishment(@NotBlank String name, @NotBlank String city, @NotBlank String address) {
        this.name = name;
        this.city = city;
        this.address = address;
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
