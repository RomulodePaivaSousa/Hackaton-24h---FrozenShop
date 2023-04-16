package org.academiadecodigo.bootcamp.glass.converters;

import org.academiadecodigo.bootcamp.glass.dto.CustomerDTO;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.academiadecodigo.bootcamp.glass.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class CustomerDTOtoCustomer implements Converter<CustomerDTO, Customer> {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer convert(CustomerDTO customerDTO) {

        Customer customer;

        if (customerService.get(customerDTO.getId()) != null){

            customer = customerService.get(customerDTO.getId());
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setEmail(customerDTO.getEmail());
            customer.setPhone(customerDTO.getPhone());
        }

        else {
           customer = new Customer();

           customer.setFirstName(customerDTO.getFirstName());
           customer.setLastName(customerDTO.getLastName());
           customer.setEmail(customerDTO.getEmail());
           customer.setPhone(customerDTO.getPhone());
        }

        return customer;
    }
}
