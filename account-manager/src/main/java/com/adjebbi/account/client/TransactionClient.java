package com.adjebbi.account.client;

import com.adjebbi.account.client.model.TransactionRequest;
import com.adjebbi.account.client.model.TransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "TransactionClient", url = "${services.transaction.url}")
public interface TransactionClient {

    @RequestMapping(method = RequestMethod.POST, value = "/transactions")
    TransactionResponse newTransaction(final TransactionRequest transactionRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/transactions/{customerID}", produces = "application/json", consumes = "application/json")
    List<TransactionResponse> getTransactionsId(@PathVariable("customerID") String customerID);

}