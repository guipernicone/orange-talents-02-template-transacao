package com.zup.transacao.entity.transaction.response;

import com.zup.transacao.entity.transaction.TransactionCard;

public class TransactionCardResponse {

    private String cardNumber;
    private String email;

    public TransactionCardResponse(TransactionCard transactionCard) {
        this.cardNumber = transactionCard.getCardNumber();
        this.email = transactionCard.getEmail();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getEmail() {
        return email;
    }
}
