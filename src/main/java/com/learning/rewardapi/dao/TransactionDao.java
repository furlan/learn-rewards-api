package com.learning.rewardapi.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.learning.rewardapi.model.Transaction;

public interface TransactionDao {
    
    int insertTransaction(UUID id, Transaction transaction);

    default int insertTransaction(Transaction transaction){
        UUID id = UUID.randomUUID();
        return insertTransaction(id, transaction);
    }

    List<Transaction> selectAllTransactions();

    Optional<Transaction> selectTransactionById(UUID id);

    int deleteTransactionById(UUID id);

    int updateTransactionById(UUID id, Transaction transaction);

    List<Transaction> selectTransactionsByCustomerId(UUID customerId);

}
