package com.kyepot.bankmanager.repository;

import com.kyepot.bankmanager.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findByAccountNumber(@Param("accountNumber") String accountNumber);
    public List<Customer> findByEmail(@Param("email") String email);
}
