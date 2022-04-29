package com.ashu.practice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MoneyCreditDTO {
    private double creditAmount;
    private String currency;
}
