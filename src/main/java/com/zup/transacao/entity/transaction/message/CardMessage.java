package com.zup.transacao.entity.transaction.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zup.transacao.entity.transaction.TransactionCard;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CardMessage {

    @NotBlank
    private String id;

    @Email
    private String email;

    @Deprecated
    public CardMessage() {}

    public CardMessage(@NotBlank String id, @Email String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public TransactionCard toModel(){
        return new TransactionCard(id, email);
    }

    @Override
    public String toString() {
        return "CardMessage{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
