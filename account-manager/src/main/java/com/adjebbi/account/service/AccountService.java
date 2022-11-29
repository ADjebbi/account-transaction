package com.adjebbi.account.service;

import com.adjebbi.account.model.Account;
import com.adjebbi.account.service.dto.AccountRequest;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
public interface AccountService {

    Account addAccount(AccountRequest accountRequest);
}
