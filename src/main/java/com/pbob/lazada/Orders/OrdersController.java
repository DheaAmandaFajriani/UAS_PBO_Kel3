package com.pbob.lazada.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Orders
 */
@Controller
@RequestMapping(path = "/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<Orders> dataOrders = this.ordersService.getAll();
        model.addAttribute("dataOrders", dataOrders);
        return "orders/index";
    }

    @GetMapping("/tambah")
    public String form_tambah(Model model) {
        return "orders/tambah";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Orders orders) {
        this.ordersService.simpan(orders);
        return "redirect:/orders/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Orders orders = this.ordersService.getById(id);

        model.addAttribute("orders", orders);

        return "orders/edit";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Orders orders = this.ordersService.getById(id);

        model.addAttribute("orders", orders);

        return "orders/view";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Orders orders) {
        this.ordersService.edit(id, orders);
        return "redirect:/orderItem/";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        this.ordersService.hapus(id);
        return "redirect:/orders/";
    }

}