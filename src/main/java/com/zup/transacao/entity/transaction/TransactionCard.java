package com.zup.transacao.entity.transaction;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Embeddable
public class TransactionCard {

    @NotNull
    private String cardNumber;
    @Email
    private String email;

    @Deprecated
    public TransactionCard() {
    }

    public TransactionCard(@NotNull String cardNumber, @Email String email) {
        this.cardNumber = cardNumber;
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getEmail() {
        return email;
    }
}
