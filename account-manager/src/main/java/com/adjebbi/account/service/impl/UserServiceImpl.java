package com.adjebbi.account.service.impl;

import com.adjebbi.account.client.TransactionClient;
import com.adjebbi.account.client.model.TransactionResponse;
import com.adjebbi.account.exception.CustomerNotFoundException;
import com.adjebbi.account.model.Customer;
import com.adjebbi.account.repository.CustomerRepository;
import com.adjebbi.account.service.UserService;
import com.adjebbi.account.service.dto.UserInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final CustomerRepository customerRepository;
    private final TransactionClient transactionClient;

    public UserServiceImpl(CustomerRepository customerRepository, TransactionClient transactionClient) {
        this.customerRepository = customerRepository;
        this.transactionClient = transactionClient;
    }

    @Override
    public Optional<UserInformation> getUserInformation(String customerID) {
        Optional<Customer> customer = customerRepository.findById(customerID);
        if (customer.isEmpty())
         throw new CustomerNotFoundException("Customer not found", null);
        return customer
                .map(c -> new UserInformation().setName(c.name)
                                               .setSurname(c.name)
                                               .setBalance("10")
                ).map(userInformation ->
                        userInformation.setTransactions(setTransactions(customerID)));
    }

    private List<TransactionResponse> setTransactions(final String customerID){
        List<TransactionResponse> transactionResponseList = null;
        try {
            transactionResponseList = transactionClient.getTransactionsId(customerID);
        }catch (Exception e){
            log.warn("Unable to retrieve transactions for the customer {} ", customerID);
        }finally {
           return transactionResponseList;
        }

    }
}
