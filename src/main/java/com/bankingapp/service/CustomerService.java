package com.bankingapp.service;

import com.bankingapp.model.dto.CreatedCustomerRequestDto;
import com.bankingapp.model.dto.CreatedCustomerResponseDto;

public interface CustomerService {
    CreatedCustomerResponseDto createdCustomer(CreatedCustomerRequestDto createdCustomerRequestDto);
}
