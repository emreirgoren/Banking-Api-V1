package com.bankingapp.service;


import com.bankingapp.model.dto.CreateCreditOrDebitRequestDto;
import com.bankingapp.model.dto.CustomerAccountResponseDto;

public interface AccountService {


    CustomerAccountResponseDto getByAccountNumber(String accountNumber);

    CustomerAccountResponseDto credit(CreateCreditOrDebitRequestDto createCreditOrDebitRequestDto);

    CustomerAccountResponseDto debit(CreateCreditOrDebitRequestDto createDebitRequestDto);

}
