package com.kyepot.bankmanager.repository;

import com.kyepot.bankmanager.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    public List<Transaction> findByAccountNumber(@Param("accountNumber") String accountNumber);
}
