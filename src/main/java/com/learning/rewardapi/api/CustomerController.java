package com.learning.rewardapi.api;

import com.learning.rewardapi.service.CustomerService;
import com.learning.rewardapi.model.Customer;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    public void addCustomer(Customer customer){
        customerService.addCustomer(customer);
    }
}
