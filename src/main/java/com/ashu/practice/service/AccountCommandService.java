package com.ashu.practice.service;

import com.ashu.practice.dto.AccountCreateDTO;
import com.ashu.practice.dto.MoneyCreditDTO;
import com.ashu.practice.dto.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {
    CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);

    CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);

    CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}

