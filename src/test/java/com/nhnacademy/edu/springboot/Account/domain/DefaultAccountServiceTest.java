package com.nhnacademy.edu.springboot.Account.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
class DefaultAccountServiceTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    void testGetAccounts() {
        List<Account> actual = accountRepository.findAll();
        Assertions.assertThat(actual).hasSize(1);
    }
}