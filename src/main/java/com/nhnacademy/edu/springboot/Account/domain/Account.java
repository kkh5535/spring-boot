package com.nhnacademy.edu.springboot.Account.domain;

public class Account {
    String number;
    Integer balance;

    public Account(String number, Integer balance) {
        this.number = number;
        this.balance = balance;
    }
}
