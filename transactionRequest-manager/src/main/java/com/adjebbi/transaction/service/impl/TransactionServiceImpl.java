package com.adjebbi.transaction.service.impl;

import com.adjebbi.transaction.model.Transaction;
import com.adjebbi.transaction.repository.TransactionRepository;
import com.adjebbi.transaction.service.TransactionService;
import com.adjebbi.transaction.service.dto.TransactionRequest;
import com.adjebbi.transaction.service.mapper.TransactionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(final TransactionRepository transactionRepository, final TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction saveTransaction(final TransactionRequest transactionRequest) {
        return transactionRepository.save(transactionMapper.toEntity(transactionRequest));
    }

    @Override
    public List<Transaction> getTransactionByCustumer(final String customerID) {
        return transactionRepository.findByCustomerID(customerID);
    }
}
