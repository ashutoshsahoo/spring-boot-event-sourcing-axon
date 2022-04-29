package com.ashu.practice.event;

import com.ashu.practice.common.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountActivatedEvent extends BaseEvent<String> {

    private final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
