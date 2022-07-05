package com.learning.rewardapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.learning.rewardapi.model.Transaction;

@Repository("fakeTransactionDao")
public class FakeTransactionDataAccessService implements TransactionDao {
    
    private static List<Transaction> DB = new ArrayList<>();

    @Override
    public int insertTransaction(UUID id, Transaction transaction){
        DB.add(new Transaction(id, transaction.getCustomerId(), transaction.getDate(), transaction.getValue(), transaction.getRewardValue()));
        return 1;
    }

    @Override
    public List<Transaction> selectAllTransactions(){
        return DB;
    }

    @Override
    public Optional<Transaction> selectTransactionById(UUID id){
        return DB.stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTransactionById(UUID id){
        Optional<Transaction> transactionMaybe = selectTransactionById(id);
        if (transactionMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(transactionMaybe.get());
        return 1;
    }

    @Override
    public int updateTransactionById(UUID id, Transaction changeTransaction){
        return selectTransactionById(id)
                .map(transaction -> {
                    int indexOfTransactionToUpdate = DB.indexOf(transaction);
                    if (indexOfTransactionToUpdate >= 0) {
                        DB.set(indexOfTransactionToUpdate, new Transaction(id, changeTransaction.getCustomerId(), changeTransaction.getDate(), changeTransaction.getValue(), changeTransaction.getRewardValue()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public List<Transaction> selectTransactionsByCustomerId(UUID customerId) {
        return DB.stream()
                .filter(transaction -> transaction.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

}
