package com.learning.rewardapi.api;

import com.learning.rewardapi.service.CustomerService;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
import com.learning.rewardapi.model.Transaction;

@RequestMapping("/api/v1/")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @PostMapping("customer")
    public void insertCustomer(@Valid @NotNull @RequestBody Customer customer){
        customerService.insertCustomer(customer);
    }

    @GetMapping("customer")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("customer/{id}")
    public Customer getCustomerById(@PathVariable("id") UUID id) {
        return customerService.getCustomerById(id)
                 .orElse(null);
    }

    @DeleteMapping("customer/{id}")
    public void deleteCustomerById(@PathVariable("id") UUID id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping("customer/{id}")
    public void updateCustomerById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Customer changeCustomer){
        customerService.updateCustomerById(id, changeCustomer);
    }

    @PostMapping("customer/{id}/transactions")
    public void addTransaction(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Transaction transaction) {
        customerService.insertTransaction(id, transaction);
        System.out.println("transactions added.");
    }
}
