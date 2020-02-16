package com.kyepot.bankmanager.model;

import com.kyepot.bankmanager.entity.Customer;

import java.util.List;

public class CustomerAccountsResponse extends Response {
    private List<Customer> customerAccounts;

    public CustomerAccountsResponse(String status, int code, String message, List<Customer> customerDetails){
        super(status, code, message);
        this.customerAccounts = customerDetails;
    }


    public List<Customer> getCustomerDetails() {
        return customerAccounts;
    }

    public void setCustomerDetails(List<Customer> customerDetails) {
        this.customerAccounts = customerDetails;
    }

}
