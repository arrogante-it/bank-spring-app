package com.bank.spring.app.repository;

import com.bank.spring.app.model.User;
import com.bank.spring.app.repository.additional.UserRepositoryAdditional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryAdditional {
}
