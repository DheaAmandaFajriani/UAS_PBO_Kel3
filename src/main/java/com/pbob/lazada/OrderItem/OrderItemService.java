package com.pbob.lazada.OrderItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * OrderItemService
 */
@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAll() {
        return this.orderItemRepository.findAll();
    }

    public void simpan(OrderItem orderItem) {
        this.orderItemRepository.save(orderItem);
    }

    public void hapus(Long id) {
        this.orderItemRepository.deleteById(id);
    }

    public OrderItem getById(Long id) {
        OrderItem orderItem = this.orderItemRepository.findById(id).orElse(null);

        return orderItem;
    }

    public void edit(Long id, OrderItem orderItem) {
        OrderItem product_lama = this.orderItemRepository.findById(id).orElse(null);

        product_lama.setOrderID(orderItem.getOrderID());
        product_lama.setProductID(orderItem.getProductID());
        product_lama.setJumlah(orderItem.getJumlah());

        this.orderItemRepository.save(product_lama);
    }
}