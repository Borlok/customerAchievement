package com.dev.demo.model;

import java.util.List;

public enum AchieveEnum {
    FIRST_STEP(1),
    OPEN_TO_THE_WORLD(2),
    EXTREME_DOWN(3);

    private final Integer id;

    AchieveEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public UDAchieve getAchieve(Customer customer) {
        UDAchieve achieve = new UDAchieve();
        achieve.setId(id);
        achieve.setCustomers(List.of(customer));
        return achieve;
    }
}
