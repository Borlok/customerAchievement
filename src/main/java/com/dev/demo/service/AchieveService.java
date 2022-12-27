package com.dev.demo.service;

import com.dev.demo.model.UDAchieve;
import com.dev.demo.model.Customer;

import java.util.Set;

public interface AchieveService extends GenericService<UDAchieve, Integer> {
    Set<UDAchieve> getAllByCustomer(Customer customer);
    Customer handleCustomerAchieves(Customer customer);
}
