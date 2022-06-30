package com.learning.rewardapi.service;

import com.learning.rewardapi.dao.CustomerDao;
import com.learning.rewardapi.model.Customer;

public class CustomerService {
    
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public int addCustomer(Customer customer){
        return customerDao.insertCustomer(customer);
    }
}
