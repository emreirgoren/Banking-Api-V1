package com.bankingapp.controller;

import com.bankingapp.model.dto.*;
import com.bankingapp.service.AccountService;
import com.bankingapp.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;
    private final CustomerService customerService;
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @PostMapping("/createAccount")
    public CreatedCustomerResponseDto createdCustomerResponseDto(@RequestBody CreatedCustomerRequestDto createdCustomerRequestDto){
        return customerService.createdCustomer(createdCustomerRequestDto);
    }

    @GetMapping("/{accountNumber}")
    public CustomerAccountResponseDto getByAccountNumber(@PathVariable("accountNumber") String accountNumber){
        return accountService.getByAccountNumber(accountNumber);
    }

    @PostMapping("/credit")
    public CustomerAccountResponseDto createCreditResponseDto(@RequestBody CreateCreditOrDebitRequestDto createCreditOrDebitRequestDto){
        return accountService.credit(createCreditOrDebitRequestDto);
    }

    @PostMapping("/debit")
    public CustomerAccountResponseDto createDebitResponseDto(@RequestBody CreateCreditOrDebitRequestDto createDebitRequestDto){
        return accountService.debit(createDebitRequestDto);
    }

}



















