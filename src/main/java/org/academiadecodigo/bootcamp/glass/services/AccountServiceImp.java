package org.academiadecodigo.bootcamp.glass.services;

import org.academiadecodigo.bootcamp.glass.dao.AccountDao;
import org.academiadecodigo.bootcamp.glass.dao.CustomerDao;
import org.academiadecodigo.bootcamp.glass.exceptions.AccountNotFoundException;
import org.academiadecodigo.bootcamp.glass.exceptions.CustomerNotFoundException;
import org.academiadecodigo.bootcamp.glass.exceptions.TransactionInvalidException;
import org.academiadecodigo.bootcamp.glass.model.account.Account;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {

    private AccountDao accountDao;
    private CustomerDao customerDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Account get(Integer id) {
        return accountDao.findById(id);
    }

    @Transactional
    @Override
    public void deposit(Integer id, Integer customerID, double amount) throws CustomerNotFoundException, AccountNotFoundException, TransactionInvalidException {


        Customer customer = Optional.ofNullable(customerDao.findById(customerID))
                .orElseThrow(CustomerNotFoundException::new);

        Account account = Optional.ofNullable(accountDao.findById(id))
                .orElseThrow(AccountNotFoundException::new);

        if (!account.getCustomer().getId().equals(customerID)) {
            throw new AccountNotFoundException();
        }

        if (!account.canCredit(amount)) {
            throw new TransactionInvalidException();
        }
        account.credit(amount);

        customerDao.saveOrUpdate(customer);
    }

    @Transactional
    @Override
    public void withdraw(Integer id, Integer customerID, double amount) throws TransactionInvalidException, AccountNotFoundException, CustomerNotFoundException {

        Customer customer = Optional.ofNullable(customerDao.findById(customerID))
                .orElseThrow(CustomerNotFoundException::new);

        Account account = Optional.ofNullable(accountDao.findById(id))
                .orElseThrow(AccountNotFoundException::new);

        // in UI the user cannot click on Withdraw so this is here for safety because the user can bypass
        // the UI limitation easily
        if (!account.canWithdraw()) {
            throw new TransactionInvalidException();
        }

        if (!account.getCustomer().getId().equals(customerID)) {
            throw new AccountNotFoundException();
        }

        // make sure transaction can be performed
        if (!account.canDebit(amount)) {
            throw new TransactionInvalidException();
        }
        account.debit(amount);
        customerDao.saveOrUpdate(customer);
    }


}


