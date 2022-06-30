package com.learning.rewardapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learning.rewardapi.dao.CustomerDao;
import com.learning.rewardapi.model.Customer;

@Service
public class CustomerService {
    
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("fakeDao") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public int addCustomer(Customer customer){
        return customerDao.insertCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }
    
}
