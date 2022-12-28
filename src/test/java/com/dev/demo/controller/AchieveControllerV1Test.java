package com.dev.demo.controller;

import com.dev.demo.config.AchieveConfiguration;
import com.dev.demo.config.ControllerTestConfig;
import com.dev.demo.dto.CustomerDto;
import com.dev.demo.model.Customer;
import com.dev.demo.service.AchieveService;
import com.dev.demo.service.CustomerService;
import com.dev.demo.service.LogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = {ControllerTestConfig.class, AchieveConfiguration.class})
@MockBean(AchieveService.class)
@MockBean(LogService.class)
@MockBean(CustomerService.class)
class AchieveControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Customer customer;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void getAllByCustomer() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setBalance(customer.getBalance());
        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.post("api/v1/achieves")
                    .content(mapper.writeValueAsString(customerDto))
                    .accept("application/json")
                    .contentType("application/json")
            ).andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
