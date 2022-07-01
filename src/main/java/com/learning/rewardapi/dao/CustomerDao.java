package com.learning.rewardapi.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.learning.rewardapi.model.Customer;

public interface CustomerDao {
    
    int insertCustomer(UUID id, Customer customer);

    default int insertCustomer(Customer customer){
        UUID id = UUID.randomUUID();
        return insertCustomer(id, customer);
    }

    List<Customer> selectAllCustomers();

    Optional<Customer> selectCustomerById(UUID id);

    int deleteCustomerById(UUID id);

    int updateCustomerById(UUID id);
}
