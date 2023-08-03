package com.bank.spring.app.repository.additional;

import com.bank.spring.app.model.Account;
import com.bank.spring.app.model.User;

import java.util.List;

public interface UserRepositoryAdditional {
    List<User> getAllUsers();

    List<Account> getAllAccounts();

    List<Account> getAccountsByUser(Long userId);

    Account getMainAccountByUserId(Long userId);
}
