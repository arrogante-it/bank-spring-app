package com.bank.spring.app.controller;

import com.bank.spring.app.model.Account;
import com.bank.spring.app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PutMapping("/accounts/{accountId}")
    public Account updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
        account.setId(accountId);
        return accountRepository.save(account);
    }

    @DeleteMapping("/accounts/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        accountRepository.deleteById(accountId);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        return accountRepository.getById(accountId);
    }
}
