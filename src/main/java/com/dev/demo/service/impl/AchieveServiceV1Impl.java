package com.dev.demo.service.impl;

import com.dev.demo.model.UDAchieve;
import com.dev.demo.model.Customer;
import com.dev.demo.repository.AchieveRepository;
import com.dev.demo.service.AchieveService;
import com.dev.demo.service.impl.achieve.AchieveHandler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class AchieveServiceV1Impl implements AchieveService {
    private final AchieveRepository repository;
    private final AchieveHandler achieveHandler;

    public AchieveServiceV1Impl(AchieveRepository repository, AchieveHandler achieveHandler) {
        this.repository = repository;
        this.achieveHandler = achieveHandler;
    }

    @Override
    public UDAchieve findById(Integer id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<UDAchieve> findAll() {
        return repository.findAll();
    }

    @Override
    public UDAchieve save(UDAchieve achieve) {
        return repository.save(achieve);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Set<UDAchieve> getAllByCustomer(Customer customer) {
        if (customer.getId() == null)
            return Collections.emptySet();
        return repository.getAllByCustomerId(customer.getId());
    }

    @Override
    public void handleCustomerAchieves(Customer customer) {
        achieveHandler.handleCustomer(customer);
    }
}
