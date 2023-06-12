package com.pbob.lazada.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * ProductService
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public void simpan(Product product) {
        this.productRepository.save(product);
    }

    public void hapus(Long id) {
        this.productRepository.deleteById(id);
    }

    public Product getById(Long id) {
        Product product = this.productRepository.findById(id).orElse(null);

        return product;
    }

    public void edit(Long id, Product product) {
        Product product_lama = this.productRepository.findById(id).orElse(null);

        product_lama.setNama(product.getNama());
        product_lama.setHarga(product.getHarga());
        product_lama.setStok(product.getStok());
        product_lama.setBrand(product.getBrand());
        product_lama.setDeskripsi(product.getDeskripsi());

        this.productRepository.save(product_lama);
    }

    public List<Product> kategori(Long id) {
        return null;
    }
}