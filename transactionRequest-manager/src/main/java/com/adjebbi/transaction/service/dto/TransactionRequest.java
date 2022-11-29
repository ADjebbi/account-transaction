package com.adjebbi.transaction.service.dto;

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
public final class TransactionRequest {

    @JsonProperty("customerID")
    public String customerID;

    @JsonProperty("accountID")
    public String accountID;

    @JsonProperty("credit")
    public String credit;

}
