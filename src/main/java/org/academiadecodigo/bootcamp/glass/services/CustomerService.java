package org.academiadecodigo.bootcamp.glass.services;

import org.academiadecodigo.bootcamp.glass.model.customer.Customer;

public interface CustomerService {

    Customer get(Integer id);

    Customer save(Customer customer);
    void delete(Integer id);

}
