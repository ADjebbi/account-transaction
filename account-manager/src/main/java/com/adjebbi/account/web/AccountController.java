package com.adjebbi.account.web;

import com.adjebbi.account.model.Account;
import com.adjebbi.account.service.AccountService;
import com.adjebbi.account.service.dto.AccountRequest;
import com.adjebbi.account.service.dto.AccountResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "accounts")
    public ResponseEntity addAccount(@RequestBody AccountRequest accountRequest){
        Account account = accountService.addAccount(accountRequest);
        return ResponseEntity.ok(new AccountResponse(account.id, account.getCustomer().getId()));
    }
}
