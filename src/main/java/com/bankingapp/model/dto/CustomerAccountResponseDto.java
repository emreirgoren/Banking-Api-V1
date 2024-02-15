package com.bankingapp.model.dto;

import com.bankingapp.model.entity.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerAccountResponseDto {

    private String firstName;

    private String lastName;

    private String email;

    @JsonIgnoreProperties({"id","createdDateTime","customerList"})
    private List<Account> accountList;

}
