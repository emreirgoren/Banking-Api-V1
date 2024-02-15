package com.bankingapp.service.impl;

import com.bankingapp.exception.AccountNotFoundException;
import com.bankingapp.exception.InsufficientBalanceException;
import com.bankingapp.exception.InvalidAmountException;
import com.bankingapp.mapper.MapperConfig;
import com.bankingapp.model.dto.CreateCreditOrDebitRequestDto;
import com.bankingapp.model.dto.CustomerAccountResponseDto;
import com.bankingapp.model.entity.Account;
import com.bankingapp.model.entity.Customer;
import com.bankingapp.repository.AccountRepository;
import com.bankingapp.service.AccountService;
import com.bankingapp.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final TransactionService transactionService;
    private final AccountRepository accountRepository;
    private final MapperConfig mapperConfig;



    public AccountServiceImpl(MapperConfig mapperConfig, AccountRepository accountRepository, TransactionService transactionService) {
        this.mapperConfig = mapperConfig;
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
    }

    @Override
    public CustomerAccountResponseDto getByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException());

        Customer customer = account.getCustomerList().get(account.getCustomerList().toArray().length - 1);

        return mapperConfig.modelMapper().map(customer, CustomerAccountResponseDto.class);
    }

    @Override
    public CustomerAccountResponseDto credit(CreateCreditOrDebitRequestDto createCreditOrDebitRequestDto) {

        Account account = accountRepository.findByAccountNumber(createCreditOrDebitRequestDto.getAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException());

        if (createCreditOrDebitRequestDto.getAmount() <= 0) {
            throw new InvalidAmountException();
        }
        account.setBalance(account.getBalance() + createCreditOrDebitRequestDto.getAmount());
        accountRepository.save(account);

        transactionService.deposit(account,createCreditOrDebitRequestDto.getAmount());

        Customer customer = account.getCustomerList().get(account.getCustomerList().toArray().length - 1);



        return mapperConfig.modelMapper().map(customer, CustomerAccountResponseDto.class);

    }

    @Override
    public CustomerAccountResponseDto debit(CreateCreditOrDebitRequestDto createDebitRequestDto) {

        Account account = accountRepository.findByAccountNumber(createDebitRequestDto.getAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException());

        if (createDebitRequestDto.getAmount() > account.getBalance()) {
            throw new InsufficientBalanceException();
        }

        account.setBalance(account.getBalance() - createDebitRequestDto.getAmount());
        accountRepository.save(account);

        transactionService.withdrawal(account,createDebitRequestDto.getAmount());

        Customer customer = account.getCustomerList().get(account.getCustomerList().toArray().length - 1);


        return mapperConfig.modelMapper().map(customer, CustomerAccountResponseDto.class);
    }

}


















