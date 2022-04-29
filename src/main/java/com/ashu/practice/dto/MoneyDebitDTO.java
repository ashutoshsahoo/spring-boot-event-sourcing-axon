package com.ashu.practice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MoneyDebitDTO {
    private double debitAmount;
    private String currency;
}
