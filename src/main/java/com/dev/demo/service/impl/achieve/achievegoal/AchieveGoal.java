package com.dev.demo.service.impl.achieve.achievegoal;

import com.dev.demo.model.AchieveEnum;
import com.dev.demo.model.Customer;

public interface AchieveGoal {
    boolean deserve(Customer customer);
    AchieveEnum type();
}
