package com.dev.demo.service.impl.achieve.achievegoal;

import com.dev.demo.model.AchieveEnum;
import com.dev.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class ExtremeDown implements AchieveGoal {
    private final AchieveEnum ACHIEVE = AchieveEnum.EXTREME_DOWN;

    @Override
    public boolean deserve(Customer customer) {
        if (customer.getBalance() < 0) {
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
