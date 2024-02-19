package com.nhnacademy.edu.springboot.Account.domain;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccount(Long id);

    Account createAccount(Account account);

    String deleteAccount(Long id);
}
