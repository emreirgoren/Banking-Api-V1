package com.bankingapp.model.dto;

import lombok.Getter;

@Getter
public class CreateCreditOrDebitRequestDto {

    private String accountNumber;
    private double amount;

}
