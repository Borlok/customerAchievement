package com.dev.demo.service.impl.achieve;

import com.dev.demo.config.AchieveConfiguration;
import com.dev.demo.model.Customer;
import com.dev.demo.model.UDAchieve;
import com.dev.demo.service.impl.achieve.achievegoal.AchieveGoal;
import com.dev.demo.service.impl.achieve.achievegoal.ExtremeDown;
import com.dev.demo.service.impl.achieve.achievegoal.FirstStep;
import com.dev.demo.service.impl.achieve.achievegoal.OpenToTheWorld;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AchieveConfiguration.class)
class AchieveGoalHandlerV1Test {
    private final Logger LOG = LoggerFactory.getLogger(AchieveGoalHandlerV1Test.class);
    @Autowired
    private Customer customer;
    @Autowired
    private List<UDAchieve> achieves;

    @BeforeEach
    public void setUp() {
    }
    @Test
    public void firstStepAchieveTest() {
        AchieveGoal achieveGoal = new FirstStep();
        LOG.info(() ->customer.toString());
        LOG.info(() ->"Achieve got if: " + achieves.get(0).getDescription());
        assertTrue(achieveGoal.deserve(customer));
    }

    @Test
    public void openToTheWorldAchieveTest() {
        AchieveGoal achieveGoal = new OpenToTheWorld();
        customer.setLastName("Volkov");
        LOG.info(() ->customer.toString());
        LOG.info(() ->"Achieve got if: " + achieves.get(1).getDescription());
        assertTrue(achieveGoal.deserve(customer));
    }

    @Test
    public void extremeDownAchieveTest() {
        AchieveGoal achieveGoal = new ExtremeDown();
        customer.setBalance(-1);
        LOG.info(() ->customer.toString());
        LOG.info(() ->"Achieve got if: " + achieves.get(2).getDescription());
        assertTrue(achieveGoal.deserve(customer));
    }
}
