package com.adjebbi.account.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class TransactionResponse {

    @JsonProperty("customerID")
    public String customerID;

    @JsonProperty("accountID")
    public String accountID;

    @JsonProperty("transationID")
    public String transationID;

    @JsonProperty("credit")
    public String credit;

}
