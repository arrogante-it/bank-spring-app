package com.bank.spring.app.controller;

import com.bank.spring.app.model.Account;
import com.bank.spring.app.model.User;
import com.bank.spring.app.repository.UserRepository;
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
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/update-user")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        user.setId(userId);
        return userRepository.save(user);
    }

    @DeleteMapping("/delete-user")
    public void deleteUser(@PathVariable Long userId, @RequestBody User user) {
        user.setId(userId);
        userRepository.delete(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.getById(userId);
    }

    @GetMapping("/users/{userId}/accounts")
    public List<Account> getAccountsByUserId(@PathVariable Long userId) {
        return userRepository.getAccountsByUser(userId);
    }

    @GetMapping("/users/{userId}/main-account")
    public Account getMainAccountByUserId(@PathVariable Long userId) {
        return userRepository.getMainAccountByUserId(userId);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return userRepository.getAllAccounts();
    }
}
