package com.pbob.lazada.Customer;

import java.util.ArrayList;
import java.util.List;

import com.pbob.lazada.OrderItem.OrderItem;
import com.pbob.lazada.Orders.Orders;
import com.pbob.lazada.User.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import lombok.Data;

/**
 * OrderItem
 */
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user")
    private User user;
    private String namaLengkap;
    private String nomorHp;
    private String alamat;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Orders> orders;

    public Customer() {
    }
   

    public Customer(Long id, User user, String namaLengkap, String nomorHp, String alamat) {
        this.id = id;
        this.user = user;
        this.namaLengkap = namaLengkap;
        this.nomorHp = nomorHp;
        this.alamat = alamat;
    }
    

   

}