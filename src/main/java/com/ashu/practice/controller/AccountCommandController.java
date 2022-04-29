package com.ashu.practice.controller;

import com.ashu.practice.dto.AccountCreateDTO;
import com.ashu.practice.dto.MoneyCreditDTO;
import com.ashu.practice.dto.MoneyDebitDTO;
import com.ashu.practice.service.AccountCommandService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/accounts")
public class AccountCommandController {

    private final AccountCommandService accountCommandService;

    public AccountCommandController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createAccount(@RequestBody AccountCreateDTO accountCreateDTO) {
        return accountCommandService.createAccount(accountCreateDTO);
    }

    @PutMapping(value = "/{accountNumber}/credits")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                          @RequestBody MoneyCreditDTO moneyCreditDTO) {
        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
    }

    @PutMapping(value = "/{accountNumber}/debits")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                           @RequestBody MoneyDebitDTO moneyDebitDTO) {
        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
    }
}
