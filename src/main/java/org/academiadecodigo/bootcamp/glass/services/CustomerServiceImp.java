package org.academiadecodigo.bootcamp.glass.services;

import org.academiadecodigo.bootcamp.glass.dao.AccountDao;
import org.academiadecodigo.bootcamp.glass.dao.CustomerDao;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

private CustomerDao customerDao;
private AccountDao accountDao;

@Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Customer get(Integer id) {
        return customerDao.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerDao.saveOrUpdate(customer);
    }

    @Override
    public void delete(Integer id) {
        customerDao.delete(id);
    }
}
