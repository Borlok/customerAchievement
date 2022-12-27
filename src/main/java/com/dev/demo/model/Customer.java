package com.dev.demo.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Integer id;
    @Transient
    private String name;
    @Transient
    private String lastName;
    @Transient
    private long balance;
    @ManyToMany
    @JoinTable(name="customers_achieves",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "achieve_id", referencedColumnName = "id"))
    @ToString.Exclude
    private Set<UDAchieve> achieves;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;

        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return 339958611;
    }
}
