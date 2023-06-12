package com.pbob.lazada.Product;



import java.util.Locale.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Product
 */
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private String deskripsi;
    private String brand;
    private int stok;
    private int harga;
    @ManyToOne
    @JoinColumn(name = "kategori_id")
    private Category kategori;

    public Product() {
    }


    public Product(Long id, String nama, String deskripsi, String brand, int stok, int harga, Category kategori) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.brand = brand;
        this.stok = stok;
        this.harga = harga;
        this.kategori = kategori;
    }
    
}