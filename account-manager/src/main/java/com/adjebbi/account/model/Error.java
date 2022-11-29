package com.adjebbi.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Data
@AllArgsConstructor
public class Error {

    @JsonProperty("code")
    private String code = null;

    @JsonProperty("response")
    private String response = null;
}
