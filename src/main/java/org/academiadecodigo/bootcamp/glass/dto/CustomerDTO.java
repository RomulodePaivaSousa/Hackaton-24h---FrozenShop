package org.academiadecodigo.bootcamp.glass.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
@Component
public class CustomerDTO {
     private int id;
     @NotNull(message = "First name is mandatory")
     @NotBlank(message = "First name is mandatory")
     @Size(min = 3, max = 45)
     private String firstName;

    @NotNull(message = "Last name is mandatory")
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, max = 45)
    private String lastName;
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank
    @NotNull(message = "Password is mandatory")
    private String password;

    @Size(min = 9, max = 16)
    private String phone;

    private String address;

    @NotNull
    @NotBlank
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
