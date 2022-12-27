package com.dev.demo.controller;

import com.dev.demo.dto.CustomerDto;
import com.dev.demo.model.Customer;
import com.dev.demo.model.LogAction;
import com.dev.demo.model.UDAchieve;
import com.dev.demo.service.AchieveService;
import com.dev.demo.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1/achieves")
public class AchieveControllerV1 {
    private final AchieveService achieveService;
    private final LogService logService;

    public AchieveControllerV1(AchieveService achieveService, LogService logService) {
        this.achieveService = achieveService;
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<Set<UDAchieve>> getAllByCustomer(@RequestBody CustomerDto customer) {
        Customer returnedCustomer = achieveService.handleCustomerAchieves(customer.toCustomer());
        Set<UDAchieve> allByCustomer = achieveService.getAllByCustomer(returnedCustomer);
        logService.saveRecord(LogAction.INFO, "Method name: getAllByCustomer | INPUT: " + customer + " | OUTPUT: " + returnedCustomer, returnedCustomer);
        return ResponseEntity.ok(allByCustomer);
    }
}
