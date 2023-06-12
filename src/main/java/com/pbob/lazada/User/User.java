package com.pbob.lazada.User;

import com.pbob.lazada.Customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "customer")
    private Customer customer;
    private String username;
    private String password;
    private String email;
    private String role;

    public User() {
    }


    public User(long id, Customer customer, String username, String password, String email, String role) {
        this.id = id;
        this.customer = customer;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
   

}
