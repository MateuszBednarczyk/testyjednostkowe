package com.example.idk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@SpringBootTest
class IdkApplicationTests {

    private CustomerService customerService;

    @BeforeEach
    private void setUpRepo(){

        CustomerRepository customerRepository = mock(CustomerRepository.class);
        Customer customer1 = new Customer(1,"Kasia");
        Customer customer2 = new Customer(2, "Mati");

        Iterable<Customer> all = Arrays.asList(customer1,customer2);
        doReturn(all).when(customerRepository).findAll();
        doReturn(all).when(customerRepository).findCustomerByCustomerName(anyString());

        customerService = new CustomerService(customerRepository);

    }

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldReturnCustomer(){

        List<Customer> actual = customerService.getCustomerList();
        Assertions.assertEquals(1,actual.get(0).getCustomerId());
        Assertions.assertEquals("Kasia",actual.get(0).getCustomerName());

    }

    @Test
    public void shouldReturnCustomerByName(){

        List<Customer> actual = customerService.getCustomerListByName("Kasia");
        System.out.println(actual);
        Assertions.assertEquals("Kasia",actual.get(0).getCustomerName());
    }
}
