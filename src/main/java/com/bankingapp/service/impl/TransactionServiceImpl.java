package com.bankingapp.service.impl;

import com.bankingapp.model.entity.Account;
import com.bankingapp.model.entity.TransactionEntity.DepositTransaction;
import com.bankingapp.model.entity.TransactionEntity.Transaction;
import com.bankingapp.model.entity.TransactionEntity.WithdrawalTransaction;
import com.bankingapp.model.enums.TransactionType;
import com.bankingapp.repository.TransactionRepository;
import com.bankingapp.service.TransactionService;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Builder
public class TransactionServiceImpl implements TransactionService {


    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(Account account, double amount){

        String approvalCode = UUID.randomUUID().toString();
        Transaction transaction = new DepositTransaction(amount);

        transaction.setAmount(amount);
        transaction.setApprovalCode(approvalCode);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setAccount(account);
        transaction.setCreatedDateTime(LocalDateTime.now());

        transactionRepository.save(transaction);

    }

    public void withdrawal(Account account, double amount){
        String approvalCode = UUID.randomUUID().toString();
        Transaction transaction = new WithdrawalTransaction();

        transaction.setAmount(amount);
        transaction.setApprovalCode(approvalCode);
        transaction.setTransactionType(TransactionType.WITHDRAW);
        transaction.setAccount(account);
        transaction.setCreatedDateTime(LocalDateTime.now());

        transactionRepository.save(transaction);

    }

}
