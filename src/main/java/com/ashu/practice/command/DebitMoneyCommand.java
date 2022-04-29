package com.ashu.practice.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DebitMoneyCommand extends BaseCommand<String> {

    private final double debitAmount;
    private final String currency;

    public DebitMoneyCommand(String id, double debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
