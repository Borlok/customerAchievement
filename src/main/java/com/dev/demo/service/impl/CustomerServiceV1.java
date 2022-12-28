package com.dev.demo.service.impl;

import com.dev.demo.model.Customer;
import com.dev.demo.model.UDAchieve;
import com.dev.demo.repository.CustomerRepository;
import com.dev.demo.service.AchieveService;
import com.dev.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerServiceV1 implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AchieveService achieveService;

    public CustomerServiceV1(CustomerRepository customerRepository, AchieveService achieveService) {
        this.customerRepository = customerRepository;
        this.achieveService = achieveService;
    }

    @Override
    public Customer getCustomerWithAchieves(Customer customer) {
        if (customer == null || customer.getId() == null)
            throw new RuntimeException("Customer is not exist");

        Customer savedCustomer = getCustomerFromRepository(customer);
        Set<UDAchieve> oldAchieves = new HashSet<>(savedCustomer.getAchieves());
        achieveService.handleCustomerAchieves(savedCustomer);
        if (!oldAchieves.containsAll(savedCustomer.getAchieves()))
            return customerRepository.save(savedCustomer);
        return savedCustomer;
    }

    private Customer getCustomerFromRepository(Customer customer) {
        Customer currentCustomer = customerRepository.findById(customer.getId()).orElseGet(() -> customerRepository.save(customer));
        currentCustomer.setName(customer.getName());
        currentCustomer.setLastName(customer.getLastName());
        currentCustomer.setBalance(customer.getBalance());
        return currentCustomer;
    }
}
