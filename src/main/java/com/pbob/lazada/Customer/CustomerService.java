package com.pbob.lazada.Customer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbob.lazada.User.User;




/**
 * CustomerService
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
   

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    
    }
    

    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    public void simpan(Customer customer) {
        this.customerRepository.save(customer);
    }

    public void hapus(Long id) {
        this.customerRepository.deleteById(id);
    }

    public Customer getById(Long id) {
        Customer customer = this.customerRepository.findById(id).orElse(null);

        return customer;
    }
    public List<Customer>user(Long id){
        return this.customerRepository.findByUserId(id);
    }

    public void edit(Long id, Customer customer) {
        Customer product_lama = this.customerRepository.findById(id).orElse(null);

        product_lama.setNamaLengkap(customer.getNamaLengkap());
        product_lama.setNomorHp(customer.getNomorHp());
        product_lama.setAlamat(customer.getAlamat());

        this.customerRepository.save(product_lama);
    }
}