package com.dev.demo.service.impl;

import com.dev.demo.config.AchieveConfiguration;
import com.dev.demo.model.Customer;
import com.dev.demo.model.UDAchieve;
import com.dev.demo.repository.AchieveRepository;
import com.dev.demo.repository.CustomerRepository;
import com.dev.demo.service.impl.achieve.AchieveHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AchieveConfiguration.class)
class AchieveGoalServiceV1ImplTest {
    private final Logger LOG = Logger.getLogger("Achieve log");
    @MockBean
    private CustomerRepository customerRepository;
    @Autowired
    private AchieveHandler achieveHandler;

    @MockBean
    private AchieveRepository achieveRepository;

    @Autowired
    private Customer customer;
    @Autowired
    private List<UDAchieve> achieves;

    @BeforeEach
    public void setUp() {
        when(achieveRepository.getAllByCustomerId(1)).thenReturn(customer.getAchieves());
        when(customerRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(customer));
    }

    @Test
    void getAllByCustomer() {
        LOG.log(Level.INFO, "Customer: " + customer.getName() + " has achieves: " + achieveRepository.getAllByCustomerId(1));
        assertEquals(Set.of(achieves.get(0)), achieveRepository.getAllByCustomerId(1));
    }

    @Test
    void handleCustomerAchieves() {
        Set<UDAchieve> resultAchieves = new LinkedHashSet<>();

        achieveHandler.handleCustomer(customer);
        LOG.log(Level.INFO, "Customer: " + customer.getName() + " has achieves: " + customer.getAchieves());
        resultAchieves.add(achieves.get(0));
        assertEquals(resultAchieves, customer.getAchieves());

        customer.setLastName("Volkov");
        achieveHandler.handleCustomer(customer);
        LOG.log(Level.INFO, "Customer: " + customer.getName() + " has achieves: " + customer.getAchieves());
        resultAchieves.add(achieves.get(1));
        assertEquals(resultAchieves, customer.getAchieves());

        customer.setBalance(-1);
        achieveHandler.handleCustomer(customer);
        LOG.log(Level.INFO, "Customer: " + customer.getName() + " has achieves: " + customer.getAchieves());
        resultAchieves.add(achieves.get(2));
        assertEquals(resultAchieves, customer.getAchieves());
    }
}
