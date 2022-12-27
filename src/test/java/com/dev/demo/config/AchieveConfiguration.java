package com.dev.demo.config;
import com.dev.demo.model.Customer;
import com.dev.demo.model.UDAchieve;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@TestConfiguration
public class AchieveConfiguration {

    @Bean
    @Scope("prototype")
    public Customer customer () {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Petr");
        customer.setLastName(null);
        customer.setBalance(15_000_000L);

        UDAchieve udAchieve = new UDAchieve();
        udAchieve.setId(1);
        udAchieve.setName("First step");
        udAchieve.setDescription("We've got when the balance more than 15 000");
        udAchieve.setCustomers(List.of(customer));

        customer.setAchieves(new HashSet<>(Set.of(udAchieve)));
        return customer;
    }

    @Bean
    public List<UDAchieve> achieves () {
        List<UDAchieve> achieves = new ArrayList<>();
        UDAchieve udAchieve = new UDAchieve();
        udAchieve.setId(1);
        udAchieve.setName("First step");
        udAchieve.setDescription("We've got when the balance more than 15 000");
        achieves.add(udAchieve);

        udAchieve = new UDAchieve();
        udAchieve.setId(2);
        udAchieve.setName("Open to the World");
        udAchieve.setDescription("When you have got fully filled account");
        achieves.add(udAchieve);

        udAchieve = new UDAchieve();
        udAchieve.setId(3);
        udAchieve.setName("Extreme down");
        udAchieve.setDescription("When you have negative balance");
        achieves.add(udAchieve);

        return achieves;
    }
}
