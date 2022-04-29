package com.ashu.practice.service;

import java.util.List;

public interface AccountQueryService {
    List<Object> listEventsForAccount(String accountNumber);
}
