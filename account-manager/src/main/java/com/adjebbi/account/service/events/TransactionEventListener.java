package com.adjebbi.account.service.events;

import com.adjebbi.account.client.model.TransactionRequest;
import com.adjebbi.account.client.model.TransactionResponse;
import com.adjebbi.account.service.impl.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Slf4j
@Component
public class TransactionEventListener {

    private final TransactionService transactionService;

    public TransactionEventListener(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @EventListener
    public void handleTransactionEvent(TransactionEvent event) {
        log.info("Received transaction event - {} ",event.toString());
        TransactionRequest transactionRequest = new TransactionRequest(event.customerID,
                event.accountID, event.credit);
        sendToTransactionService(transactionRequest);

    }

    private void sendToTransactionService(TransactionRequest transactionRequest){
        try {
            Optional<TransactionResponse> transaction =
                    Optional.ofNullable(transactionService.addTransaction(transactionRequest));
            transaction.ifPresent(t -> log.info("Transaction created {}", transaction.get().toString()));
        }catch (Exception e){
            log.info("Exception while reading transactions");
        }

    }
}