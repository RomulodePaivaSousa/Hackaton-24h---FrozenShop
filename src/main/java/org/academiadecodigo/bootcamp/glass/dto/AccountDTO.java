package org.academiadecodigo.bootcamp.glass.dto;

import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.springframework.stereotype.Component;


@Component
public class AccountDTO {
    private Integer id;
    private double balance = 0;
    private Customer customer;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
