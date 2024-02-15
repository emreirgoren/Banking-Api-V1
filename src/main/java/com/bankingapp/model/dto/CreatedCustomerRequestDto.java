package com.bankingapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatedCustomerRequestDto {


    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;


}
