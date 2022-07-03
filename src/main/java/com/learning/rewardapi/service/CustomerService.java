package com.learning.rewardapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<Customer> getCustomerById(UUID id){
        return customerDao.selectCustomerById(id);
    }

    public int deleteCustomerById(UUID id) {
        return customerDao.deleteCustomerById(id);
    }

    public int updateCustomerById(UUID id, Customer changeCustomer) {
        return customerDao.updateCustomerById(id, changeCustomer);
    }
    
}
