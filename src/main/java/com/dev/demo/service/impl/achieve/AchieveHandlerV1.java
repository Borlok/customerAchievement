package com.dev.demo.service.impl.achieve;

import com.dev.demo.model.UDAchieve;
import com.dev.demo.model.Customer;
import com.dev.demo.service.impl.achieve.achievegoal.AchieveGoal;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AchieveHandlerV1 implements AchieveHandler {
    private final Set<AchieveGoal> achieveGoals;

    public AchieveHandlerV1(Set<AchieveGoal> achieveGoals) {
        this.achieveGoals = achieveGoals;
    }

    @Override
    public void handleCustomer(Customer customer) {
        if (customer == null || customer.getId() == null)
            throw new RuntimeException("Customer is not exist");

        Set<Integer> currentCustomerAchieveIds = customer.getAchieves().stream()
                .map(UDAchieve::getId).collect(Collectors.toSet());

        for (AchieveGoal achieveGoal : achieveGoals)
            if (!currentCustomerAchieveIds.contains(achieveGoal.type().getId()))
                achieveGoal.deserve(customer);
    }
}
