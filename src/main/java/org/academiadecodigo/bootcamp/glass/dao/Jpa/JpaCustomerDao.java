package org.academiadecodigo.bootcamp.glass.dao.Jpa;

import org.academiadecodigo.bootcamp.glass.dao.CustomerDao;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {
    public JpaCustomerDao() {
        super(Customer.class);
    }
}
