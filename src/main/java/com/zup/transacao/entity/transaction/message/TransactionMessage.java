package com.zup.transacao.entity.transaction.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zup.transacao.entity.transaction.Transaction;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionMessage {

    @JsonProperty("id")
    @NotBlank
    private String id;

    @JsonProperty("valor")
    @NotNull
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    @NotNull
    private EstablishmentMessage establishmentMessage;

    @JsonProperty("cartao")
    @NotNull
    private CardMessage cardMessage;

    @JsonProperty("efetivadaEm")
    private String effectiveOn;

    @Deprecated
    public TransactionMessage() {
    }

    public TransactionMessage(
            @NotBlank String id,
            @NotNull BigDecimal value,
            @NotNull EstablishmentMessage establishmentMessage,
            @NotNull CardMessage cardMessage,
            @NotNull String effectiveOn
    ) {
        this.id = id;
        this.value = value;
        this.establishmentMessage = establishmentMessage;
        this.cardMessage = cardMessage;
        this.effectiveOn = effectiveOn;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentMessage getEstablishmentMessage() {
        return establishmentMessage;
    }

    public CardMessage getCardMessage() {
        return cardMessage;
    }

    public String getEffectiveOn() {
        return effectiveOn;
    }

    public Transaction toModel(){
        return new Transaction(id, value, establishmentMessage.toModel(), cardMessage.toModel(), effectiveOn);
    }

    @Override
    public String toString() {
        return "TransactionMessage{" +
                "id='" + id + '\'' +
                ", value=" + value +
                ", establishmentMessage=" + establishmentMessage.toString() +
                ", cardMessage=" + cardMessage.toString() +
                ", effectiveOn=" + effectiveOn +
                '}';
    }
}
