package com.example.idk;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerAPI {

    private CustomerService customerService;

    public CustomerAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers(){

        return customerService.getCustomerList();

    }

    @GetMapping("/all/{name}")
    public List<Customer> getAllCustomersByName(@PathVariable String name){

        return customerService.getCustomerListByName(name);

    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer){

        customerService.saveCustomer(customer);

    }
}
