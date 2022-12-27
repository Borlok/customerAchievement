package com.dev.demo.service.impl.achieve;

import com.dev.demo.model.UDAchieve;
import com.dev.demo.model.Customer;
import com.dev.demo.repository.CustomerRepository;
import com.dev.demo.service.impl.achieve.achievegoal.AchieveGoal;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AchieveHandlerV1 implements AchieveHandler {
    private final CustomerRepository customerRepository;
    private final Set<AchieveGoal> achieveGoals;

    public AchieveHandlerV1(CustomerRepository customerRepository, Set<AchieveGoal> achieveGoals) {
        this.customerRepository = customerRepository;
        this.achieveGoals = achieveGoals;
    }

    @Override
    public Customer handleCustomer(Customer customer) {
        if (customer == null || customer.getId() == null)
            throw new RuntimeException("Customer is not exist");

        Customer currentCustomer = getCustomerFromRepository(customer);
        Set<Integer> currentCustomerAchieveIds = currentCustomer.getAchieves().stream()
                .map(UDAchieve::getId).collect(Collectors.toSet());

        boolean isReceiveAchieve = false;
        for (AchieveGoal achieveGoal : achieveGoals)
            if (!currentCustomerAchieveIds.contains(achieveGoal.type().getId()))
                if (achieveGoal.deserve(currentCustomer))
                    isReceiveAchieve = true;

        if (isReceiveAchieve)
            return customerRepository.save(currentCustomer);
        return currentCustomer;
    }

    private Customer getCustomerFromRepository(Customer customer) {
        Customer currentCustomer = customerRepository.findById(customer.getId()).orElseGet(() -> customerRepository.save(customer));
        currentCustomer.setName(customer.getName());
        currentCustomer.setLastName(customer.getLastName());
        currentCustomer.setBalance(customer.getBalance());
        return currentCustomer;
    }
}
