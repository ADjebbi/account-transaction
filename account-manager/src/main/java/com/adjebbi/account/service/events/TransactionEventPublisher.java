package com.adjebbi.account.service.events;

import com.adjebbi.account.service.events.TransactionEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Slf4j
@Component
public class TransactionEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishTransactionEvent(final String customerID, final String accountID, final String credit) {
        log.debug("Publishing transactionEvent");
        TransactionEvent transactionEvent = new TransactionEvent(this, customerID, accountID, credit);
        applicationEventPublisher.publishEvent(transactionEvent);
    }


}