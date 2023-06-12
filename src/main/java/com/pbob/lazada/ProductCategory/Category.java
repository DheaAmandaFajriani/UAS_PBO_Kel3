package com.pbob.lazada.ProductCategory;
import java.util.ArrayList;
import java.util.List;

import com.pbob.lazada.Product.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kategori;

    @OneToMany(mappedBy = "kategori", cascade = CascadeType.ALL)
    private List<Product> produk;

    public Category() {
    }

    public Category(String kategori) {
        this.kategori = kategori;
    }
}
