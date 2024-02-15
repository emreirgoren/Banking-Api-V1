package com.bankingapp.utils;

import com.bankingapp.model.entity.Account;
import com.bankingapp.repository.AccountRepository;
import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.Random;

@Configuration
public class GenerateAccountNumber {

    private final AccountRepository accountRepository;

    public GenerateAccountNumber(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Generate Account Number
     */
    public String createUniqueAccountNumber() {
        String accountNumber;
        do {
            String randomNumber = generateAccountNumber();
            accountNumber = randomNumber.substring(0, 3) + "-" + randomNumber.substring(3, 6) + "-" + randomNumber.substring(6);
        } while (isUniqueAccountNumber(accountNumber));
        return accountNumber;
    }

    private String generateAccountNumber() {
        Random random = new Random();
        // 10 basamaklı banka hesap numarasını oluşturmak için
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomBasamak = random.nextInt(10);
            accountNumber.append(randomBasamak);
        }
        return accountNumber.toString();
    }

    private boolean isUniqueAccountNumber(String accountNumber) {
        Optional<Account> existingAccount = accountRepository.findByAccountNumber(accountNumber);
        return existingAccount.isPresent();
    }

}
