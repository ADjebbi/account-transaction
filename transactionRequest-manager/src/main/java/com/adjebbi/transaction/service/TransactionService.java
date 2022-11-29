package com.adjebbi.transaction.service;

import com.adjebbi.transaction.model.Transaction;
import com.adjebbi.transaction.service.dto.TransactionRequest;

import java.util.List;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
public interface TransactionService {

    Transaction saveTransaction(final TransactionRequest transactionRequest);

    List<Transaction> getTransactionByCustumer(final String customerID);

}
