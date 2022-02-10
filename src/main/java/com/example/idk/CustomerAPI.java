package com.example.idk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer){

        customerService.saveCustomer(customer);

    }
}
