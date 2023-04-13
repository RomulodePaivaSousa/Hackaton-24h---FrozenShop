package org.academiadecodigo.bootcamp.glass.model;

import org.academiadecodigo.bootcamp.glass.model.AbstractModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "customer")
public class Customer extends AbstractModel {


    private String name;
    @Column(unique = true)
    private String email;

    private String address;
    @Column(unique = true)
    private int phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
