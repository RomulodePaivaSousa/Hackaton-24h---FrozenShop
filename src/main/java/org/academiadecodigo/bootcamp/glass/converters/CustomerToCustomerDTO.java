package org.academiadecodigo.bootcamp.glass.converters;

import org.academiadecodigo.bootcamp.glass.dto.CustomerDTO;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDTO extends AbstractConverter<Customer, CustomerDTO> {

    @Override
    public CustomerDTO convert(Customer customer) {

        CustomerDTO customerDTO= new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        return super.convert(customer);
    }
}
