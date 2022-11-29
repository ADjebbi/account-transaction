package com.adjebbi.account.service.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
public class TransactionEvent extends ApplicationEvent {

    public String customerID;

    public String accountID;

    public String credit;

    public TransactionEvent(Object source, String customerID, String accountID, String credit) {
        super(source);
        this.customerID = customerID;
        this.accountID = accountID;
        this.credit = credit;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "TransactionEvent{" +
                "customerID='" + customerID + '\'' +
                ", accountID='" + accountID + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
