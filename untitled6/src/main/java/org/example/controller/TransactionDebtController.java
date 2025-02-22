package org.example.controller;

import org.example.model.TransactionDebt;
import org.example.service.TransactionDebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionDebtController {
    private final TransactionDebtService transactionDebtService;
    private TransactionDebtService transactionService;

    @Autowired
    public TransactionDebtController(TransactionDebtService transactionDebtService) {
        this.transactionDebtService = transactionDebtService;
    }

    public TransactionDebtController(TransactionDebtService transactionDebtService, TransactionDebtService transactionService) {
        this.transactionDebtService = transactionDebtService;
        this.transactionService = transactionService;
    }

    /*@GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
       List<Transaction> transactions = transactionDebtService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }*/

   /* @GetMapping("/{id}")
    public ResponseEntity<jakarta.transaction.Transaction> getTransactionById(@PathVariable Long id) {
        Optional<jakarta.transaction.Transaction> transaction = transactionDebtService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/

    @PostMapping
    public ResponseEntity<TransactionDebt> createTransaction(@RequestBody TransactionDebt transactionDebt) {
        TransactionDebt createdTransaction = transactionDebtService.createTransaction(transactionDebt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }
}
