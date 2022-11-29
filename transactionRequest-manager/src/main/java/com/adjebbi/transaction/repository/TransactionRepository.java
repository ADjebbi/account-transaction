package com.adjebbi.transaction.repository;

import com.adjebbi.transaction.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
public interface TransactionRepository extends CrudRepository<Transaction, String> {

    List<Transaction> findByCustomerID(String customerID);

}
