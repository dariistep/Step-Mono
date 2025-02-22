package org.example.service;

import org.antlr.v4.runtime.misc.LogManager;
import org.example.model.TransactionDebt;
import org.example.repository.TransactionDebtRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class TransactionDebtService {

    private final TransactionDebtRepository transactionDebtRepository;
    @Autowired
    public TransactionDebtService(TransactionDebtRepository transactionDebtRepository) {
        this.transactionDebtRepository = transactionDebtRepository;
    }

    public List<Transaction> getAllTransactionsByUserId(Long userId) {
        return transactionDebtRepository.findByUserId(userId);
    }

    public Optional<TransactionDebt> getTransactionById(Long transactionId) {
        return transactionDebtRepository.findById(transactionId);
    }

    public void updateTransactionDebt(TransactionDebt transactionDebt) throws IOException {
        LogManager transactionRepository = null;
        transactionRepository.save(transactionDebt.toString());

        jakarta.transaction.Transaction TransactionDebt = null;
        org.example.model.TransactionDebt Transaction = null;
        transactionDebtRepository.save(Transaction);///вернуть файл
    }

    public List<TransactionDebt> getAllTransactions() {
        return transactionDebtRepository.findAll();
    }

   /* public double calculateTotalDebt(List<Transaction> transactions) {
        double totalDebt = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getSumaDebt() < 0) {
                totalDebt += Math.abs(transaction.getSumaDebt());
            }
        }
        return totalDebt;
    }*/



    public TransactionDebt createTransaction(TransactionDebt transactionDebt) {
        return transactionDebtRepository.save(transactionDebt);
    }
}
