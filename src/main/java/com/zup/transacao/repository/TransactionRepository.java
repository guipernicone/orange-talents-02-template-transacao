package com.zup.transacao.repository;

import com.zup.transacao.entity.transaction.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findFirst10ByCardCardNumber(String cardNumber);
}
