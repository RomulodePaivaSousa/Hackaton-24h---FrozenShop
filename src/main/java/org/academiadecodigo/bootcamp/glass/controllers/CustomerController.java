package org.academiadecodigo.bootcamp.glass.controllers;

import org.academiadecodigo.bootcamp.glass.converters.CustomerDTOtoCustomer;
import org.academiadecodigo.bootcamp.glass.converters.CustomerToCustomerDTO;
import org.academiadecodigo.bootcamp.glass.dto.CustomerDTO;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.academiadecodigo.bootcamp.glass.services.CustomerService;
import org.academiadecodigo.bootcamp.glass.services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {

    private CustomerService customerService;
    private CustomerDTOtoCustomer customerDtoToCustomer;
    private CustomerToCustomerDTO customerToCustomerDto;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerDtoToCustomer(CustomerDTOtoCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @Autowired
    public void setCustomerToCustomerDto(CustomerToCustomerDTO customerToCustomerDto) {
        this.customerToCustomerDto = customerToCustomerDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<CustomerDTO> showCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CustomerDTO customerDTO = customerToCustomerDto.convert(customer);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/customer/add"})
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

        Customer customer1;
        if (customer.getId() != null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {


            customer1 = new Customer();

            customer1.setFirstName(customer.getFirstName());
            customer1.setLastName(customer.getLastName());
            customer1.setEmail(customer.getEmail());
            customer1.setPhone(customer.getPhone());
            customer1.setPassword(customer.getPassword());

            customerService.save(customer1);
        }

        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/customer/{id}")
    public ResponseEntity<CustomerDTO> editCustomer(@Valid @RequestBody CustomerDTO customerDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerDto.getId() != null && !customerDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Customer customer = customerService.get(id);

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setPassword(customerDto.getPassword());

        customerDto.setId(id);
        customerService.save(customerDtoToCustomer.convert(customerDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {

        customerService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.POST, path = "/customer/login")
    public ResponseEntity<Customer> customerLogin(@RequestBody Customer customer) {

        Customer customer1;

        if (customerService.findByEmail(customer.getEmail()) != null) {
            customer1 = customerService.findByEmail(customer.getEmail());

            if (customer.getPassword().equals(customer1.getPassword())) {
                return new ResponseEntity<>(customer1, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customer/subscribeLight/{id}")
    public ResponseEntity<Customer> subscribeLight(@PathVariable int id ) {

       Customer customer = customerService.get(id);
       customer.setBalance(customerService.get(id).getBalance() - 15);
       customerService.save(customer);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customer/subscribeMedium/{id}")
    public ResponseEntity<Customer> subscribeMedium(@PathVariable int id ) {

        Customer customer = customerService.get(id);
        customer.setBalance(customerService.get(id).getBalance() - 40);
        customerService.save(customer);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customer/subscribeMax/{id}")
    public ResponseEntity<Customer> subscribeMax(@PathVariable int id ) {

        Customer customer = customerService.get(id);
        customer.setBalance(customerService.get(id).getBalance() - 100);
        customerService.save(customer);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customer/deposit/{id}/{amount}")
    public ResponseEntity<Customer> deposit(@RequestParam("id") int id, @RequestParam("amount") int amount) {

        Customer customer = customerService.get(id);
        customer.setBalance(customerService.get(id).getBalance() + amount);
        customerService.save(customer);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/balance/{id}")
    public ResponseEntity<?> balanceCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer.getBalance(), HttpStatus.OK);
    }

}
