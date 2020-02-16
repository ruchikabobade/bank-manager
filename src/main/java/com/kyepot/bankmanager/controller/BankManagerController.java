package com.kyepot.bankmanager.controller;

import com.kyepot.bankmanager.model.*;
import com.kyepot.bankmanager.service.BankManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BankManagerController {

    private Logger logger = LoggerFactory.getLogger(BankManagerController.class);

    @Autowired
    private BankManagerService service;

    @RequestMapping(value = "/v1/bank/account", method = RequestMethod.POST)
    public CustomerResponse createNewAccount(@RequestBody CustomerAccountRequest newAccountRequest){
        logger.info("New Account Request Received.");
        return service.createNewCustomerAccount(newAccountRequest);
    }

    @RequestMapping(value = "/v1/bank/account/deposit", method = RequestMethod.POST)
    public CustomerResponse depositMoney(@RequestBody TransactionOperation transactionRequest){
        logger.info("New deposit Request Received.");
        return service.depositAmount(transactionRequest);
    }

    @RequestMapping(value = "/v1/bank/account/withdraw", method = RequestMethod.POST)
    public CustomerResponse withdrawMoney(@RequestBody TransactionOperation transactionRequest){
        logger.info("New withdraw Request Received.");
        return service.withdrawAmount(transactionRequest);
    }

    @RequestMapping(value = "/v1/bank/account/{email}", method = RequestMethod.GET)
    public CustomerAccountsResponse getAccounts(@PathVariable String email){
        logger.info("New enquiry Request for accounts Received.");
        return service.getAccountsOfCustomer(email);
    }

    @RequestMapping(value = "/v1/bank/account/transactions/{accountNumber}", method = RequestMethod.GET)
    public TransactionResponse fetchTransactions(@PathVariable String accountNumber){
        logger.info("New enquiry Request for transactions Received.");
        return service.getTransactions(accountNumber);
    }

    @RequestMapping(value = "/v1/bank/account/enquiry/{accountNumber}", method = RequestMethod.GET)
    public CustomerResponse getAccountDetails(@PathVariable String accountNumber){
        logger.info("New enquiry Request for account details Received.");
        return service.accountDetails(accountNumber);
    }
}
