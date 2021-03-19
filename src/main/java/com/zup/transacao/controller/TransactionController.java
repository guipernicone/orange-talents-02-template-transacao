package com.zup.transacao.controller;

import com.zup.transacao.entity.transaction.Transaction;
import com.zup.transacao.entity.transaction.response.TransactionResponse;
import com.zup.transacao.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/{cardNumber}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getTransactions(@PathVariable(value = "cardNumber") String cardNumber){
        List<Transaction> transactionList = transactionRepository.findFirst10ByCardCardNumber(cardNumber);

        if(transactionList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        List<TransactionResponse> transactionResponseList = transactionList
                .stream()
                .map(TransactionResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(transactionResponseList);
    }

}
