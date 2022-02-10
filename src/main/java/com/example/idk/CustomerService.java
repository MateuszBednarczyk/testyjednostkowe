package com.example.idk;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public List<Customer> getCustomerListByName(String name){

        return customerRepository.findCustomerByCustomerName(name);

    }

}
