package com.nhnacademy.edu.springboot.Account.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAccountService implements AccountService{
    private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account createAccount(Account account) {
        if (accountRepository.existsById(account.getId())) {
            throw new IllegalStateException("already exists");
        }
        return accountRepository.save(account);
    }

    @Override
    public String deleteAccount(Long id) {
        accountRepository.deleteById(id);
        return "Ok";
    }
}
