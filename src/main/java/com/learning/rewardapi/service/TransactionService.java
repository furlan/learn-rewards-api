package com.learning.rewardapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learning.rewardapi.dao.TransactionDao;
import com.learning.rewardapi.model.Transaction;

@Service
public class TransactionService {
    
    private final TransactionDao transactionDao;

    @Autowired
    public TransactionService(@Qualifier("fakeTransactionDao") TransactionDao transactionDao){
        this.transactionDao = transactionDao;
    }

    public int insertTransaction(Transaction transaction){
        return transactionDao.insertTransaction(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionDao.selectAllTransactions();
    }

    public Optional<Transaction> getTransactionById(UUID id){
        return transactionDao.selectTransactionById(id);
    }

    public int deleteTransactionById(UUID id){
        return transactionDao.deleteTransactionById(id);
    }

    public int updateTransactionById(UUID id, Transaction transaction){
        return transactionDao.updateTransactionById(id, transaction);
    }
}
