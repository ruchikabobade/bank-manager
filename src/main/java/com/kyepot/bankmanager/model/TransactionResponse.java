package com.kyepot.bankmanager.model;

import com.kyepot.bankmanager.entity.Transaction;

import java.util.List;

public class TransactionResponse {
    private String status;
    private int code;
    private String message;

    private List<Transaction> transactions;

    public TransactionResponse(String status, int code, String message, List<Transaction> transactions){
        this.status = status;
        this.code = code;
        this.message = message;
        this.transactions = transactions;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
