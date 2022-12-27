package com.dev.demo.service.impl.achieve;

import com.dev.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public interface AchieveHandler {
    Customer handleCustomer(Customer customer);
}
