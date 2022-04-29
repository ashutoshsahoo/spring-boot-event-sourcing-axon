package com.ashu.practice.command;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
@ToString
public class BaseCommand<T> {
    @TargetAggregateIdentifier
    private final T id;

    public BaseCommand(T id) {
        this.id = id;
    }
}
