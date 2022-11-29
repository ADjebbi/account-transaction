package com.adjebbi.account.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Data
@NoArgsConstructor
public class Transaction {

    @JsonProperty("accountID")
    public String accountID;

    @JsonProperty("transationID")
    public String transationID;

    @JsonProperty("amount")
    public String amount;

}
