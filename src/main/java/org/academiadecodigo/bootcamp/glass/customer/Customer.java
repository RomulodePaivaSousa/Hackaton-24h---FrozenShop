package org.academiadecodigo.bootcamp.glass.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends AbstractModel{

    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column
    private String address;
    @Column(unique = true)
    private int phone;



}
