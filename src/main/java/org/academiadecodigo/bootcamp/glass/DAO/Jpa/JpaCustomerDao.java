package org.academiadecodigo.bootcamp.glass.DAO.Jpa;

import org.academiadecodigo.bootcamp.glass.DAO.CustomerDao;
import org.academiadecodigo.bootcamp.glass.customer.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {
    public JpaCustomerDao(Class<Customer> modelType) {
        super(modelType);
    }
}
