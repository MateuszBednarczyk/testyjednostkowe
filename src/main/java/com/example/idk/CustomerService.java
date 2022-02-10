package com.example.idk;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomer(Customer customer) {

        customerRepository.save(customer);

    }

    public List<Customer> getCustomerList() {

        return customerRepository.findAll();

    }

}
