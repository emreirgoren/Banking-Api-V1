package com.bankingapp.repository;

import com.bankingapp.model.entity.Account;
import com.bankingapp.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional findByFirstName(String firstName);

    Optional findByLastName(String lastName);

    Account findByAccountList_AccountNumber(String accountNumber);
}
