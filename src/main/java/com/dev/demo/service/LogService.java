package com.dev.demo.service;

import com.dev.demo.model.LogAction;

public interface LogService {
    void saveRecord(LogAction logAction, String msg, Object obj);
}
