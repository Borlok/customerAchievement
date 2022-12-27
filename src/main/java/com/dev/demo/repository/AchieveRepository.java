package com.dev.demo.repository;

import com.dev.demo.model.UDAchieve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AchieveRepository extends JpaRepository<UDAchieve, Integer> {
    @Query(value = "select * from achieves a" +
            " join customers_achieves ca on a.id = ca.achieve_id where ca.customer_id = ?1", nativeQuery = true)
    Set<UDAchieve> getAllByCustomerId(Integer id);
}
