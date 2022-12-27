package com.dev.demo.service.impl;

import com.dev.demo.model.Customer;
import com.dev.demo.model.LogAction;
import com.dev.demo.model.LogRecord;
import com.dev.demo.repository.LogRepository;
import com.dev.demo.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogServiceV1 implements LogService {
    private final LogRepository logRepository;
    private final Logger LOG = LoggerFactory.getLogger(LogServiceV1.class);


    public LogServiceV1(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void saveRecord(LogAction logAction, String msg, Object obj) {
        LOG.info("SAVE RECORD");
        Customer customer = (Customer) obj;
        LogRecord logRecord = new LogRecord();
        logRecord.setMsg(msg);
        logRecord.setCreated(new Date());
        logRecord.setLogAction(logAction);
        logRecord.setCustomerId(customer.getId());
        logRecord.setCustomerName(customer.getName());
        logRecord.setCustomerLastName(customer.getLastName());
        logRecord.setCustomerBalance(customer.getBalance());
        logRepository.save(logRecord);
    }
}
