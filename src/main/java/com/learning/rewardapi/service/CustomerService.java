package com.learning.rewardapi.service;

import java.math.BigDecimal;
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

    public int insertCustomer(Customer customer){
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
        Optional<Customer> customerMaybe = customerDao.selectCustomerById(transaction.getCustomerId());
        if (customerMaybe.isEmpty()) {
            return 0;
        }
        Customer customer = customerMaybe.get();
        Reward reward = customer.getReward();
        BigDecimal rewardValue = reward.getRewardValue(transaction.getValue());
        transaction.setRewardValue(rewardValue);
        //to-do: save
        return transactionDao.insertTransaction(transaction);
    }
    
}
