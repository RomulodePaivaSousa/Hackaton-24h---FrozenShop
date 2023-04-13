package org.academiadecodigo.bootcamp.glass.model.account;


import org.academiadecodigo.bootcamp.glass.model.customer.AbstractModel;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends AbstractModel {

    private double balance = 0;

    @OneToOne
    private Customer customer;

    public void credit(double amount) {
        if (canCredit(amount)) {
            balance += amount;
        }
    }

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

    public void debit(double amount) {
        if (canDebit(amount)) {
            balance -= amount;
        }
    }

    public boolean canDebit(double amount) {
        return amount > 0 && amount <= balance;
    }

    public boolean canWithdraw() {
        return true;
    }

    public boolean canCredit(double amount) {
        return amount > 0;
    }


    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
