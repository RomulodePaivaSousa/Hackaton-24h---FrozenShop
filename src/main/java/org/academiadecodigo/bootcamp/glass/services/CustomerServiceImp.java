package org.academiadecodigo.bootcamp.glass.services;


import org.academiadecodigo.bootcamp.glass.dao.CustomerDao;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerServiceImp implements CustomerService {

private CustomerDao customerDao;


    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
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

    @Override
    public Customer findByEmail(String email) {
        return customerDao.findByEmail(email);
    }
}
