package com.learning.rewardapi.api;

import com.learning.rewardapi.service.CustomerService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.rewardapi.model.Customer;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{id}")
    public Customer getCustomerById(@PathVariable("id") UUID id) {
        return customerService.getCustomerById(id)
                 .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomerById(@PathVariable("id") UUID id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping(path = "{id}")
    public void updateCustomerById(@PathVariable("id") UUID id, @RequestBody Customer changeCustomer){
        customerService.updateCustomerById(id, changeCustomer);
    }
}
