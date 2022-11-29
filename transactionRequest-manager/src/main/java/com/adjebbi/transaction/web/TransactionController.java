package com.adjebbi.transaction.web;

import com.adjebbi.transaction.model.Transaction;
import com.adjebbi.transaction.service.TransactionService;
import com.adjebbi.transaction.service.dto.TransactionRequest;
import com.adjebbi.transaction.service.dto.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.adjebbi.transaction.service.dto.TransactionResponse.TransactionResponseBuilder;
import static java.util.stream.Collectors.toList;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Slf4j
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "transactions")
    public ResponseEntity addTransaction(@RequestBody TransactionRequest transactionRequest){
        log.info(" Receive transaction {} ", transactionRequest.toString());
        Transaction transaction = transactionService.saveTransaction(transactionRequest);
        TransactionResponse response = new TransactionResponseBuilder()
                .setAccountID(transaction.accountID)
                .setCustomerID(transaction.customerID)
                .setTransationID(transaction.id)
                .setCredit(transaction.getCredit())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/transactions/{customerID}")
    public ResponseEntity getAllTransactionsByCustomerId(@PathVariable String customerID){
        log.info(" Receive get transactions for customer {} ", customerID);
        List<Transaction> transactions = transactionService.getTransactionByCustumer(customerID);
        List<TransactionResponse> transactionResponseList = transactions.stream()
                .map(t -> new TransactionResponseBuilder()
                            .setAccountID(t.accountID)
                            .setCustomerID(t.customerID)
                            .setTransationID(t.id)
                            .setCredit(t.getCredit())
                            .build()
                )
                .collect(toList());
        return ResponseEntity.ok(transactionResponseList);
    }
}
