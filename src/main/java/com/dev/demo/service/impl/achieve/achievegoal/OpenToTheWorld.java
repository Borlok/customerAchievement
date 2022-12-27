package com.dev.demo.service.impl.achieve.achievegoal;

import com.dev.demo.model.AchieveEnum;
import com.dev.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class OpenToTheWorld implements AchieveGoal {
    private final AchieveEnum ACHIEVE = AchieveEnum.OPEN_TO_THE_WORLD;

    @Override
    public boolean deserve(Customer customer) {
        if (customer.getName() != null &&
                customer.getLastName() != null) {
            customer.getAchieves().add(ACHIEVE.getAchieve(customer));
            return true;
        }
        return false;
    }

    @Override
    public AchieveEnum type() {
        return ACHIEVE;
    }
}
