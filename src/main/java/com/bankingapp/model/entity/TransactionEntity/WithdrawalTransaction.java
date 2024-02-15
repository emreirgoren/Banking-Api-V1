package com.bankingapp.model.entity.TransactionEntity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class WithdrawalTransaction extends Transaction{

    public WithdrawalTransaction(double amount){
        super(amount);
    }

}
