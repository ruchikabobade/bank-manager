package com.kyepot.bankmanager.service;


import com.kyepot.bankmanager.constants.Constants;
import com.kyepot.bankmanager.dao.CustomerDao;
import com.kyepot.bankmanager.dao.TransactionDao;
import com.kyepot.bankmanager.entity.Customer;
import com.kyepot.bankmanager.entity.Transaction;
import com.kyepot.bankmanager.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static net.logstash.logback.argument.StructuredArguments.kv;
import static net.logstash.logback.argument.StructuredArguments.v;

import java.util.List;

@Service
public class BankManagerService {

    private Logger logger = LoggerFactory.getLogger(BankManagerService.class);

    @Autowired
    private CustomerDao dao;

    @Autowired
    private TransactionDao transactionDao;

    public CustomerResponse createNewCustomerAccount(CustomerAccountRequest newAccountRequest){
        Customer customer = dao.createNewCustomer(newAccountRequest);
        logger.info("New customer account created." , kv("customer" , customer));
        return new CustomerResponse(Constants.newAccountSuccessMessage,Constants.successCode, Constants.success, customer);
    }

    public CustomerResponse accountDetails(String accountNumber){
        Customer customer = dao.getCustomerDetails(accountNumber);
        logger.info("Customer Account details retrieved." , kv("customer" , customer));
        return new CustomerResponse(Constants.newAccountSuccessMessage,Constants.successCode, Constants.success, customer);

    }


    public CustomerResponse depositAmount(TransactionOperation transactionRequest){

        try {

            Customer customer = dao.getCustomerDetails(transactionRequest.getAccountNumber());
            double balance = customer.getBalnceAmount();
            balance = balance + transactionRequest.getAmount();
            customer.setBalnceAmount(balance);
            customer = dao.updateCustomer(customer);
            transactionDao.createTransaction(transactionRequest, balance);
            logger.info("Amount deposited into the customer account" , v("closing_balance", balance));
            return new CustomerResponse(Constants.amountDepositedMessage, Constants.successCode, Constants.success, customer);

        } catch(NullPointerException ne){
            logger.error(Constants.invalidAccountMessageDeposit, v("account_number", transactionRequest.getAccountNumber()));
            return new CustomerResponse(Constants.invalidAccountMessage + transactionRequest.getAccountNumber() + " does not exist.", Constants.errorCode, Constants.error, null);

        }

    }

    public CustomerResponse withdrawAmount(TransactionOperation transactionRequest){

        try {

            Customer customer = dao.getCustomerDetails(transactionRequest.getAccountNumber());

            double balance = customer.getBalnceAmount();
            if (balance >= transactionRequest.getAmount()) {
                balance = balance - transactionRequest.getAmount();
                customer.setBalnceAmount(balance);
                customer = dao.updateCustomer(customer);
                transactionDao.createTransaction(transactionRequest, balance);
                logger.info("Amount withdrawn from the customer account" , v("closing_balance", balance));
                return new CustomerResponse(Constants.amountWithdrawnMessage, Constants.successCode, Constants.success, customer);
            } else {
                logger.error(Constants.insufficientBalanceMessage);
                return new CustomerResponse(Constants.insufficientBalanceMessage, Constants.errorCode, Constants.error, customer);

            }
        } catch(NullPointerException ne){
            logger.error(Constants.invalidAccountMessageWithdrawn, v("account_number", transactionRequest.getAccountNumber()));
            return new CustomerResponse(Constants.invalidAccountMessage + transactionRequest.getAccountNumber() + " does not exist.", Constants.errorCode, Constants.error, null);

        }
    }

    public CustomerAccountsResponse getAccountsOfCustomer(String email){
        List<Customer> accounts = dao.getAccountsOfCustomer(email);
        logger.info(Constants.accountsEnquirySuccessMessage, v("accounts", accounts.size()), v("email", email));
        return new CustomerAccountsResponse(Constants.success, Constants.successCode, accounts.size() + Constants.accountsSuccessMessage + email, accounts);
    }

    public TransactionResponse getTransactions(String accountNumber){
        List<Transaction> transactionList = transactionDao.getAllTransactions(accountNumber);
        logger.info(Constants.transactionsEnquirySuccessMessage, v("transactions", transactionList.size()), v("account_number", accountNumber));
        return new TransactionResponse(Constants.success, Constants.successCode, transactionList.size()+ Constants.transactionsSuccessMessage + accountNumber, transactionList);
    }



}
