package com.kyepot.bankmanager.model;

import com.kyepot.bankmanager.entity.Customer;

public class CustomerResponse extends Response{

    private Customer customerDetails;

    public CustomerResponse(String status, int code, String message, Customer customerDetails){
        super(status, code, message);
        this.customerDetails = customerDetails;
    }


    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

}
