package com.ashu.practice.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MoneyCreditedEvent extends BaseEvent<String> {

    private final double creditAmount;

    private final String currency;

    public MoneyCreditedEvent(String id, double creditAmount, String currency) {
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }
}
