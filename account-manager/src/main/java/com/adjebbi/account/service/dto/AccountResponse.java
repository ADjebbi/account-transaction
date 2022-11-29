package com.adjebbi.account.service.dto;

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
public final class AccountResponse {

    @JsonProperty("accountID")
    public String accountID;

    @JsonProperty("customerID")
    public String customerID;

}
