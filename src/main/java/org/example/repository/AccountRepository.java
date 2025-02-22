package org.example.repository;

import org.example.model.Account;
import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByOwner(User user);

    List<Account> findByUser(User user);

    List<Account> findByOwnerId(Long userId);
}