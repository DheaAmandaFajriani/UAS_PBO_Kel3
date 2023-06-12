package com.pbob.lazada.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Orders
 */
@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAll() {
        return this.ordersRepository.findAll();
    }

    public void simpan(Orders orders) {
        this.ordersRepository.save(orders);
    }

    public void hapus(Long id) {
        this.ordersRepository.deleteById(id);
    }

    public Orders getById(Long id) {
        Orders orders = this.ordersRepository.findById(id).orElse(null);

        return orders;
    }

    public void edit(Long id, Orders orders) {
        Orders product_lama = this.ordersRepository.findById(id).orElse(null);

        product_lama.setTanggalOrder(orders.getTanggalOrder());
        product_lama.setStatus(orders.getStatus());
        product_lama.setPaymentStatus(orders.getPaymentStatus());
        product_lama.setShippingStatus(orders.getShippingStatus());

        this.ordersRepository.save(product_lama);
    }
}