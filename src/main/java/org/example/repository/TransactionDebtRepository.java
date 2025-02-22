package org.example.repository;

import jakarta.transaction.Transaction;
import org.example.model.Account;
import org.example.model.TransactionDebt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionDebtRepository extends JpaRepository<TransactionDebt, Long> {
    List<Transaction> findByAccount(Account account);

    List<org.hibernate.Transaction> findByUserId(Long userId);

}
