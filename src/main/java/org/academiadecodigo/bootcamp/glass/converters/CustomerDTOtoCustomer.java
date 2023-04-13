package org.academiadecodigo.bootcamp.glass.converters;

import org.academiadecodigo.bootcamp.glass.DTO.CustomerDTO;
import org.academiadecodigo.bootcamp.glass.customer.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOtoCustomer implements Converter<CustomerDTO, Customer> {
//falta o customer services e criar construtor com anotação autoWired

    @Override
    public Customer convert(CustomerDTO customerDTO) {
        Customer customer = (customerDTO != null ? customer.get(customerDTO.getId()) : new Customer());

        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        return customer;
    }
}
