package com.dev.demo.repository;


import com.dev.demo.model.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogRecord, Long> {
}
