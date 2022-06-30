package com.learning.rewardapi.dao;

import java.util.UUID;

import com.learning.rewardapi.model.Customer;

public interface CustomerDao {
    
    int insertCustomer(UUID id, Customer customer);

    default int insertCustomer(Customer customer){
        UUID id = UUID.randomUUID();
        return insertCustomer(id, customer);
    }


}
