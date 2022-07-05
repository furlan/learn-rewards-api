package com.learning.rewardapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.learning.rewardapi.model.Customer;

@Repository("fakeCustomerDao")
public class FakeCustomerDataAccessService implements CustomerDao {
    
    private static List<Customer> DB = new ArrayList<>();

    @Override
    public UUID insertCustomer(UUID id, Customer customer){
        DB.add(new Customer(id, customer.getName()));
        return id;
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
        Optional<Customer> customerMaybe = selectCustomerById(id);
        if (customerMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(customerMaybe.get());
        return 1;
    }

    @Override
    public int updateCustomerById(UUID id, Customer changeCustomer){
        // Java streams, map
        return selectCustomerById(id)
                .map(customer -> {
                    int indexOfCustomerToUpdate = DB.indexOf(customer);
                    if (indexOfCustomerToUpdate >= 0) {   // Customer found
                        DB.set(indexOfCustomerToUpdate, new Customer(id, changeCustomer.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
