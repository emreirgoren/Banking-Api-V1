package com.bankingapp.repository;

import com.bankingapp.model.entity.TransactionEntity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
