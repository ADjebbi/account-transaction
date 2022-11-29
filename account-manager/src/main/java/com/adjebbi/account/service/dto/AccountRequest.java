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
public final class AccountRequest {

    @JsonProperty("customerID")
    public String customerID;

    @JsonProperty("initialCredit")
    public String initialCredit;

}
