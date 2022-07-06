package com.learning.rewardapi.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learning.rewardapi.dao.CustomerDao;
import com.learning.rewardapi.dao.TransactionDao;
import com.learning.rewardapi.model.Customer;
import com.learning.rewardapi.model.Reward;
import com.learning.rewardapi.model.RewardMonth;
import com.learning.rewardapi.model.Transaction;

@Service
public class CustomerService {
    
    private final CustomerDao customerDao;
    private final TransactionDao transactionDao;

    @Autowired
    public CustomerService(@Qualifier("fakeCustomerDao") CustomerDao customerDao, 
                           @Qualifier("fakeTransactionDao") TransactionDao transactionDao) {
        this.customerDao = customerDao;
        this.transactionDao = transactionDao;
    }

    public UUID insertCustomer(Customer customer){
        return customerDao.insertCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Optional<Customer> getCustomerById(UUID id){
        return customerDao.selectCustomerById(id);
    }

    public int deleteCustomerById(UUID id) {
        return customerDao.deleteCustomerById(id);
    }

    public int updateCustomerById(UUID id, Customer changeCustomer) {
        return customerDao.updateCustomerById(id, changeCustomer);
    }

    public int insertTransaction(UUID id, Transaction transaction) {
        Optional<Customer> customerMaybe = customerDao.selectCustomerById(id);
        if (customerMaybe.isEmpty()) {
            return 0;
        }
        Customer customer = customerMaybe.get();
        transaction.setCustomerId(id);
        Reward reward = customer.getReward();
        BigDecimal rewardValue = reward.getRewardValue(transaction.getValue());
        transaction.setRewardValue(rewardValue);
        return transactionDao.insertTransaction(transaction);
    }

    public List<Transaction> getTransactionsByCustomerId(UUID id){
        return transactionDao.selectTransactionsByCustomerId(id);
    }

    public List<RewardMonth> getRewardMonthsByCustomerId(UUID id){
        List<Transaction> transactions = transactionDao.selectTransactionsByCustomerId(id);
        List<RewardMonth> rewards = new ArrayList<RewardMonth>();
        
        // Using HashMap to summarize total by months (already sorted)
        HashMap<Integer, BigDecimal> months = new HashMap<Integer, BigDecimal>();
        
        Integer month = 0;
        BigDecimal rewardValue = BigDecimal.ZERO;

        for (Transaction transaction: transactions){
            month = transaction.getDate().getDayOfMonth();
            if (months.get(month) == null){
                rewardValue = transaction.getRewardValue();
            } else {
                rewardValue = months.get(month).add(transaction.getRewardValue());
                
            };
            months.put(month, rewardValue);
        }
        
        for (Integer key : months.keySet()){
            rewards.add(new RewardMonth(id, key, months.get(key)));
        }

        return rewards;
            
    }
    
}
