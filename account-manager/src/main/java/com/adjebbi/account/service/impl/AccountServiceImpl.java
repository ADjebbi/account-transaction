package com.adjebbi.account.service.impl;

import com.adjebbi.account.service.events.TransactionEventPublisher;
import com.adjebbi.account.exception.CustomerNotFoundException;
import com.adjebbi.account.model.Account;
import com.adjebbi.account.repository.AccountRepository;
import com.adjebbi.account.service.AccountService;
import com.adjebbi.account.service.dto.AccountRequest;
import com.adjebbi.account.service.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    private final TransactionEventPublisher transactionEventPublisher;

    public AccountServiceImpl(AccountMapper accountMapper, AccountRepository accountRepository, TransactionEventPublisher transactionEventPublisher) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
        this.transactionEventPublisher = transactionEventPublisher;
    }

    @Override
    public Account addAccount(AccountRequest accountRequest) {
        log.info("Receive accountDto {}", accountRequest.toString());
        try {
            return switch (accountRequest.initialCredit) {
                case "0":
                    log.info("Create account without transaction");
                    yield accountRepository.save(accountMapper.toEntity(accountRequest));
                case default:
                    log.info("Create account with transaction");
                    Account account = accountRepository.save(accountMapper.toEntity(accountRequest));
                    transactionEventPublisher
                                .publishTransactionEvent(account.getCustomer().getId(), account.getId(), accountRequest.initialCredit);
                    yield account;
            };
        }catch (JpaObjectRetrievalFailureException e){
            throw  new CustomerNotFoundException(e.getMessage(), e.getRootCause());
        }
    }


}
