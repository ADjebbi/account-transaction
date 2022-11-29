package com.adjebbi.transaction.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
public final class TransactionResponse {

    @JsonProperty("customerID")
    public String customerID;

    @JsonProperty("accountID")
    public String accountID;

    @JsonProperty("transationID")
    public String transationID;

    @JsonProperty("credit")
    public String credit;

    public TransactionResponse(TransactionResponseBuilder builder) {
        this.customerID = builder.customerID;
        this.accountID = builder.accountID;
        this.transationID = builder.transationID;
        this.credit = builder.credit;
    }

    public static class TransactionResponseBuilder{
        public String customerID;
        public String accountID;
        public String transationID;
        public String credit;

        public TransactionResponseBuilder setCustomerID(String customerID){
            this.customerID = customerID;
            return this;
        }

        public TransactionResponseBuilder setAccountID(String accountID){
            this.accountID = accountID;
            return this;
        }

        public TransactionResponseBuilder setTransationID(String transationID){
            this.transationID = transationID;
            return this;
        }

        public TransactionResponseBuilder setCredit(String credit){
            this.credit = credit;
            return this;
        }

        public TransactionResponse build(){
            return new TransactionResponse(this);
        }

    }
}
