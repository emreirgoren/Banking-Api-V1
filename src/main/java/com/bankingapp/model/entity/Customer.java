package com.bankingapp.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="customer_accounts",
               joinColumns = @JoinColumn(name = "customer_id"),
               inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Account> accountList= new ArrayList<>();

    public void accountListAdd(Account account){
        this.accountList.add(account);
    }

    public void accountAdd(Account account){
        this.accountList.add(account);
    }

}
