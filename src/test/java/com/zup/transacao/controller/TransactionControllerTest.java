package com.zup.transacao.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.zup.transacao.entity.transaction.Transaction;
import com.zup.transacao.entity.transaction.TransactionCard;
import com.zup.transacao.entity.transaction.TransactionEstablishment;
import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    @WithMockUser
    public void testGetTransactionsNotFound() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/transactions/{cardNumber}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @Transactional
    @WithMockUser
    public void testGetTransactions() throws Exception {
        TransactionEstablishment establishment = new TransactionEstablishment(
                "Hortifruti",
                "Campinas",
                "Rua Teste"
        );
        TransactionCard card = new TransactionCard(
                "1",
                "email@test.com.br"
        );
        Transaction transaction = new Transaction(
                "10",
                new BigDecimal(100),
                establishment,
                card,
                String.valueOf(LocalDateTime.now())
        );
        entityManager.persist(transaction);

       MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/transaction/{cardNumber}", transaction.getCard().getCardNumber())
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        JsonElement jsonElement = JsonParser.parseString(result.getResponse().getContentAsString());
        Assertions.assertEquals("10", jsonElement.getAsJsonArray().get(0).getAsJsonObject().get("transactionNumber").getAsString());


    }
}
