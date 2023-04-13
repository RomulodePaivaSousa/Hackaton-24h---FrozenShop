package org.academiadecodigo.bootcamp.glass.services;

import org.academiadecodigo.bootcamp.glass.exceptions.AccountNotFoundException;
import org.academiadecodigo.bootcamp.glass.exceptions.CustomerNotFoundException;
import org.academiadecodigo.bootcamp.glass.exceptions.TransactionInvalidException;
import org.academiadecodigo.bootcamp.glass.model.account.Account;

public interface AccountService {

    Account get(Integer id);
    void deposit(Integer id, Integer customerID, double amount) throws CustomerNotFoundException, AccountNotFoundException, TransactionInvalidException;
    void withdraw(Integer id, Integer customerID, double amount) throws TransactionInvalidException, AccountNotFoundException, CustomerNotFoundException;
}
