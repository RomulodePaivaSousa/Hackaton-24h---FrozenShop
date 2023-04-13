package org.academiadecodigo.bootcamp.glass.controllers;

import org.academiadecodigo.bootcamp.glass.converters.AccountDtotoAccount;
import org.academiadecodigo.bootcamp.glass.converters.AccounttoAccountDto;
import org.academiadecodigo.bootcamp.glass.dto.AccountDTO;
import org.academiadecodigo.bootcamp.glass.exceptions.AccountNotFoundException;
import org.academiadecodigo.bootcamp.glass.exceptions.CustomerNotFoundException;
import org.academiadecodigo.bootcamp.glass.exceptions.TransactionInvalidException;
import org.academiadecodigo.bootcamp.glass.model.account.Account;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.academiadecodigo.bootcamp.glass.services.AccountService;
import org.academiadecodigo.bootcamp.glass.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.stream.Collectors;

import javax.validation.Valid;
import java.util.List;


/*
@RestController
@RequestMapping("/api/customer")
public class AccountController {

    private CustomerService customerService;
    private AccountService accountService;
    private AccounttoAccountDto accounttoAccountDto;
    private AccountDtotoAccount accountDtotoAccount;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setAccounttoAccountDto(AccounttoAccountDto accounttoAccountDto) {
        this.accounttoAccountDto = accounttoAccountDto;
    }

    @Autowired
    public void setAccountDtotoAccount(AccountDtotoAccount accountDtotoAccount) {
        this.accountDtotoAccount = accountDtotoAccount;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/account/{aid}")
    public ResponseEntity<AccountDTO> showCustomerAccount(@PathVariable Integer cid, @PathVariable Integer aid) {

        Account account = accountService.get(aid);

        if (account == null || account.getCustomer() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!account.getCustomer().getId().equals(cid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(accounttoAccountDto.convert(account), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/{cid}/account")
    public ResponseEntity<?> addAccount(@PathVariable Integer cid, @Valid @RequestBody AccountDTO accountDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || accountDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {

            Account account = customerService.addAccount(cid, accountDtotoAccount.convert(accountDto));

            UriComponents uriComponents = uriComponentsBuilder.path("/api/customer/" + cid + "/account/" + account.getId()).build();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);

        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (TransactionInvalidException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/account/{aid}/close")
    public ResponseEntity<?> closeAccount(@PathVariable Integer cid, @PathVariable Integer aid) {

        try {

            customerService.closeAccount(cid, aid);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (AccountNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (TransactionInvalidException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
}*/

