package com.bankingapp.model.entity.TransactionEntity;

import com.bankingapp.model.entity.Account;
import com.bankingapp.model.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "approval_code")
    private String approvalCode;

    @Column(name = "transaction_type", updatable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @Column(name = "created_date_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdDateTime;

    public Transaction(double amount){
        this.amount=amount;
    }

}
