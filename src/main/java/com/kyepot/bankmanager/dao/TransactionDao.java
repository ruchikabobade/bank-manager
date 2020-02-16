package com.kyepot.bankmanager.dao;

import com.kyepot.bankmanager.entity.Transaction;
import com.kyepot.bankmanager.model.TransactionOperation;
import com.kyepot.bankmanager.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionDao {

    @Autowired
    private TransactionRepository repository;

    public void createTransaction(TransactionOperation transactionRequest, double balance){
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(transactionRequest.getAccountNumber());
        transaction.setOperation(transactionRequest.getOperation());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setClosingBalance(balance);
        repository.save(transaction);
    }

    public List<Transaction> getAllTransactions(String accountNumber){
        return repository.findByAccountNumber(accountNumber);
    }
}
