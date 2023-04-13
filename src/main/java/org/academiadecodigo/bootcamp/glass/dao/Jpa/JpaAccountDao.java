package org.academiadecodigo.bootcamp.glass.dao.Jpa;

import org.academiadecodigo.bootcamp.glass.dao.AccountDao;
import org.academiadecodigo.bootcamp.glass.model.account.Account;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAccountDao extends GenericJpaDao<Account> implements AccountDao {
    public JpaAccountDao() {
        super(Account.class);
    }
}
