package com.dev.demo.dto;

import com.dev.demo.model.Customer;
import lombok.Data;

import java.util.HashSet;

@Data
public class CustomerDto {
    private Integer id;
    private String name;
    private String lastName;
    private long balance;

    public Customer toCustomer() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setLastName(lastName);
        customer.setBalance(balance);
        customer.setAchieves(new HashSet<>());
        return customer;
    }
}
