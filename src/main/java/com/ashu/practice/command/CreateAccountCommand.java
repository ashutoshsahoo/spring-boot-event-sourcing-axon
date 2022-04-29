package com.ashu.practice.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateAccountCommand extends BaseCommand<String> {

    private final double accountBalance;
    private final String currency;

    public CreateAccountCommand(String id, double accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
