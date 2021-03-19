package com.zup.transacao.listener;

import com.zup.transacao.entity.transaction.Transaction;
import com.zup.transacao.entity.transaction.message.TransactionMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class TransactionListener {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionMessage message){
        System.out.println(message.toString());
        Transaction transaction = message.toModel();
        entityManager.persist(transaction);
    }
}
