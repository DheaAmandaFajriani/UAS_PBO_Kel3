package com.pbob.lazada.OrderItem;



import com.pbob.lazada.Customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * OrderItem
 */
@Data
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int orderID;
    private int productID;
    private int jumlah;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Customer customer;

    public OrderItem() {
    }


    public OrderItem(Long id, int orderID, int productID, int jumlah, Customer customer) {
        this.id = id;
        this.orderID = orderID;
        this.productID = productID;
        this.jumlah = jumlah;
        this.customer = customer;
    }
    
}