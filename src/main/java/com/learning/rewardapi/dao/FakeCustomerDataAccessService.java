package com.learning.rewardapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.learning.rewardapi.model.Customer;

@Repository("fakeDao")
public class FakeCustomerDataAccessService implements CustomerDao {
    
    private static List<Customer> DB = new ArrayList<>();

    @Override
    public int insertCustomer(UUID id, Customer customer){
        DB.add(new Customer(id, customer.getName()));
        return 1;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return DB;
    }

    @Override
    public Optional<Customer> selectCustomerById(UUID id){
        return DB.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCustomerById(UUID id){
        return 0;
    }

    @Override
    public int updateCustomerById(UUID id){
        return 0;
    }
}
