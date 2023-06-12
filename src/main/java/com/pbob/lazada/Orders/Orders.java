package com.pbob.lazada.Orders;

import java.util.Date;



import com.pbob.lazada.Customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

/**
 * Orders
 */
@Data
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date tanggalOrder;
    // private Customer customer;
    private String status;
    private Boolean paymentStatus;
    private String shippingStatus;
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    public Orders() {
    }


    public Orders(Long id, Date tanggalOrder, String status, Boolean paymentStatus, String shippingStatus, Customer customer) {
        this.id = id;
        this.tanggalOrder = tanggalOrder;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.shippingStatus = shippingStatus;
        this.customer = customer;
    }
   
}