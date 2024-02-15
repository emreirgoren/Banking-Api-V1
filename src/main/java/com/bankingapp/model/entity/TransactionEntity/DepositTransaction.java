package com.bankingapp.model.entity.TransactionEntity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class DepositTransaction extends Transaction{

    public DepositTransaction(double amount){
        super(amount);
    }

}
