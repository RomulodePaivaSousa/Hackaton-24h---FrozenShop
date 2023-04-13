package org.academiadecodigo.bootcamp.glass.converters;

import org.academiadecodigo.bootcamp.glass.dto.AccountDTO;
;
import org.academiadecodigo.bootcamp.glass.model.account.Account;
import org.springframework.stereotype.Component;

@Component
public class AccounttoAccountDto extends AbstractConverter<Account, AccountDTO>{
    @Override
    public AccountDTO convert(Account account) {

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId(account.getId());
        accountDTO.setBalance(account.getBalance());



        return accountDTO;
    }
}
