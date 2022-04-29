package com.ashu.practice.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseEvent<T> {

    private final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
