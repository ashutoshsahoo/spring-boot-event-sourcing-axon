package com.ashu.practice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccountCreateDTO {
    private double startingBalance;
    private String currency;
}
