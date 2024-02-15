package com.bankingapp.service;

import com.bankingapp.model.entity.Account;

public interface TransactionService {
    void deposit(Account account, double amount);

    void withdrawal(Account account, double amount);
}
