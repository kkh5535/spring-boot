package com.nhnacademy.edu.springboot.Account.domain;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
}
