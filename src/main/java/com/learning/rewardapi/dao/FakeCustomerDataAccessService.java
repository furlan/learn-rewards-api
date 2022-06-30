package com.learning.rewardapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.learning.rewardapi.model.Customer;

public class FakeCustomerDataAccessService implements CustomerDao {
    
    private static List<Customer> DB = new ArrayList<>();

    @Override
    public int insertCustomer(UUID id, Customer customer){
        DB.add(new Customer(id, customer.getName()));
        return 0;
    }
}
