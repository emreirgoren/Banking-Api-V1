package com.bankingapp.service.impl;

import com.bankingapp.exception.CustomerAlreadyExistsException;
import com.bankingapp.mapper.MapperConfig;
import com.bankingapp.model.dto.CreatedCustomerRequestDto;
import com.bankingapp.model.dto.CreatedCustomerResponseDto;
import com.bankingapp.model.entity.Account;
import com.bankingapp.model.entity.Customer;
import com.bankingapp.repository.AccountRepository;
import com.bankingapp.repository.CustomerRepository;
import com.bankingapp.service.CustomerService;
import com.bankingapp.utils.GenerateAccountNumber;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final MapperConfig mapperConfig;
    private final GenerateAccountNumber generateAccountNumber;

    public CustomerServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository,
                               MapperConfig mapperConfig,
                               GenerateAccountNumber generateAccountNumber) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.mapperConfig = mapperConfig;
        this.generateAccountNumber = generateAccountNumber;
    }

    @Override
    public CreatedCustomerResponseDto createdCustomer(CreatedCustomerRequestDto createdCustomerRequestDto) {

        customerRepository.findByFirstName(createdCustomerRequestDto.getFirstName());

        if(customerRepository.findByFirstName(createdCustomerRequestDto.getFirstName()).isPresent()
                && customerRepository.findByLastName(createdCustomerRequestDto.getLastName()).isPresent()){
            throw new CustomerAlreadyExistsException();
        }

        Customer customer = mapperConfig.modelMapper().map(createdCustomerRequestDto, Customer.class);
        Account account = new Account();
        account.setCreatedDateTime(LocalDateTime.now());
        account.setAccountNumber(generateAccountNumber.createUniqueAccountNumber());
        customer.accountAdd(account);

        accountRepository.save(account);
        customerRepository.save(customer);


        return mapperConfig.modelMapper().map(customer,CreatedCustomerResponseDto.class);
    }


}
