package com.kyepot.bankmanager.dao;

import com.kyepot.bankmanager.entity.Customer;
import com.kyepot.bankmanager.model.CustomerAccountRequest;
import com.kyepot.bankmanager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CustomerDao {

    @Autowired
    private CustomerRepository repository;

    public Customer createNewCustomer(CustomerAccountRequest request){
        Customer customer = new Customer();

        customer.setEmail(request.getEmail());
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setAccountNumber(getAccountNumber());
        customer.setBalnceAmount(0.0);

        return repository.save(customer);
    }


    public Customer getCustomerDetails(String accountNumber){
        return repository.findByAccountNumber(accountNumber);
    }

    public List<Customer> getAccountsOfCustomer(String email){
        return repository.findByEmail(email);
    }

    public Customer updateCustomer(Customer customer){
        return repository.save(customer);
    }

    public String getAccountNumber(){
        return "KY-" + UUID.randomUUID().toString();
    }
}
