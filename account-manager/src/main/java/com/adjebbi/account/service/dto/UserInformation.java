package com.adjebbi.account.service.dto;

import com.adjebbi.account.client.model.TransactionResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Data
@NoArgsConstructor
public class UserInformation {

    @JsonProperty("name")
    public String name;

    @JsonProperty("surname")
    public String surname;

    @JsonProperty("balance")
    public String balance;

    @JsonProperty("transactions")
    public List<TransactionResponse> transactions;

    public UserInformation setName(String name){
        this.name = name;
        return this;
    }

    public UserInformation setSurname(String surname){
        this.surname = surname;
        return this;
    }

    public UserInformation setBalance(String balance){
        this.balance = balance;
        return this;
    }

    public UserInformation setTransactions(List<TransactionResponse> transactions){
        this.transactions = transactions;
        return this;
    }
}
