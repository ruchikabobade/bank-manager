package com.kyepot.bankmanager.model;

import com.kyepot.bankmanager.entity.Transaction;

import java.util.List;

public class TransactionResponse extends Response{

    private List<Transaction> transactions;

    public TransactionResponse(String status, int code, String message, List<Transaction> transactions){
        super(status, code, message);
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
