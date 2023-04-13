package org.academiadecodigo.bootcamp.glass.converters;

import org.academiadecodigo.bootcamp.glass.dto.AccountDTO;
import org.academiadecodigo.bootcamp.glass.model.account.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountDtotoAccount implements Converter<AccountDTO, Account> {


    @Override
    public Account convert(AccountDTO accountDTO) {

        Account account = new Account();
        account.credit(accountDTO.getBalance() != 0 ? accountDTO.getBalance():0);


        return account;
    }
}
