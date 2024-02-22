package com.nhnacademy.edu.springboot.Account.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class AccountRepositorySliceTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    long accountId;
    Account account;

    @BeforeEach
    void setup() {
        accountId = 1L;
        account = new Account(accountId, "me", 100);
        entityManager.merge(account);
    }

    @Test
    void testFindAll() throws Exception {
//        long accountId = 1L;
//        Account account = new Account(accountId, "me", 100);
//        entityManager.merge(account);

        List<Account> actual = accountRepository.findAll();

        Assertions.assertThat(actual.get(0)).isEqualTo(account);
    }
    @Test
    void testFindById() throws Exception {
//        long accountId = 1L;
//        Account account = new Account(accountId, "me", 100);
//        entityManager.merge(account);

        Optional<Account> actual = accountRepository.findById(accountId);

        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(account);
    }

    @Test
    void testFindByNumber() throws Exception {
//        long accountId = 1L;
//        Account account = new Account(accountId, "me", 100);
//        entityManager.merge(account);

        Optional<Account> actual = accountRepository.findByNumber("me");

        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(account);
    }

    @Test
    void testSave() throws Exception {
//        long accountId = 1L;
//        Account account = new Account(accountId, "me", 100);
//        entityManager.merge(account);

//        Account actual = accountRepository.save(account);
//
//        Assertions.assertThat(actual.get(0)).isEqualTo(account);
    }

//    @Test
//    void testFindAll() throws Exception {
//        long accountId = 1L;
//        Account account = new Account(accountId, "me", 100);
//        entityManager.merge(account);
//
//        List<Account> actual = accountRepository.findAll();
//
//        Assertions.assertThat(actual.get(0)).isEqualTo(account);
//    }
}
