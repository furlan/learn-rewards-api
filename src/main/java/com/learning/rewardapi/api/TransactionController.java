package com.learning.rewardapi.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.rewardapi.model.Transaction;
import com.learning.rewardapi.service.TransactionService;

@RequestMapping("/api/v1/")
@RestController
public class TransactionController {
    
    public final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping("transaction")
    public void insertTransaction(@Valid @NotNull @RequestBody Transaction transaction){
        transactionService.insertTransaction(transaction);
    }

    @GetMapping("transaction")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @DeleteMapping("transaction/{id}")
    public void deleteTransactionById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Transaction transaction){
        transactionService.deleteTransactionById(id);
    }

    @PutMapping("transaction/{id}")
    public void updateTransactionById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Transaction transaction){
        transactionService.updateTransactionById(id, transaction);
    }

}
