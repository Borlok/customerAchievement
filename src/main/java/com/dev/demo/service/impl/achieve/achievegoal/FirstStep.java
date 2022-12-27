package com.dev.demo.service.impl.achieve.achievegoal;

import com.dev.demo.model.AchieveEnum;
import com.dev.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class FirstStep implements AchieveGoal {
    private final AchieveEnum ACHIEVE = AchieveEnum.FIRST_STEP;

    @Override
    public boolean deserve(Customer customer) {
        long ACHIEVED_BALANCE = 1_500_000;
        if (customer.getBalance() >= ACHIEVED_BALANCE) {
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
