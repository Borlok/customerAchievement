package com.dev.demo.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "logs")
public class LogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String msg;
    private Date created;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "name")
    private String customerName;
    @Column(name = "last_name")
    private String customerLastName;
    @Column(name = "balance")
    private long customerBalance;
    @Column(name = "log_action")
    @Enumerated(EnumType.STRING)
    private LogAction logAction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LogRecord logRecord = (LogRecord) o;

        return Objects.equals(id, logRecord.id);
    }

    @Override
    public int hashCode() {
        return 797362980;
    }
}
