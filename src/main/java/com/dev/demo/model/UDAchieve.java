package com.dev.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "achieves")
public class UDAchieve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;

    @ManyToMany(mappedBy = "achieves")
    @ToString.Exclude
    @JsonIgnore
    private List<Customer> customers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UDAchieve achieve = (UDAchieve) o;

        return Objects.equals(id, achieve.id);
    }

    @Override
    public int hashCode() {
        return 1976551614;
    }
}
