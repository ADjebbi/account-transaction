package com.adjebbi.account.service.impl;

import com.adjebbi.account.client.TransactionClient;
import com.adjebbi.account.client.model.TransactionRequest;
import com.adjebbi.account.client.model.TransactionResponse;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Slf4j
@Service
public class TransactionService {

    @Autowired
    private RetryRegistry registry;
    private final TransactionClient transactionClient;

    @PostConstruct
    public void postConstruct() {
        registry
                .retry("addTransaction")
                .getEventPublisher()
                .onRetry(System.out::println);
    }

    public TransactionService(TransactionClient transactionClient) {
        this.transactionClient = transactionClient;
    }

    @Retry(name = "addTransaction", fallbackMethod = "transactionFallBack")
    public TransactionResponse addTransaction(TransactionRequest transactionRequest){
        return transactionClient.newTransaction(transactionRequest);
    }

    private TransactionResponse transactionFallBack(TransactionRequest transactionRequest, RuntimeException ex) {
        log.info("Save failed transaction in the Database");
        return null;
    }
}
