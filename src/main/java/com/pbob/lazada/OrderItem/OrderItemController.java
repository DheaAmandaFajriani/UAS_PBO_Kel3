package com.pbob.lazada.OrderItem;

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
 * OrderItemController
 */
@Controller
@RequestMapping(path = "/orderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<OrderItem> dataOrderItem = this.orderItemService.getAll();
        model.addAttribute("dataOrderItem", dataOrderItem);
        return "orderItem/index";
    }

    @GetMapping("/tambah")
    public String form_tambah(Model model) {
        return "orderItem/tambah";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute OrderItem orderItem) {
        this.orderItemService.simpan(orderItem);
        return "redirect:/orderItem/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        OrderItem orderItem = this.orderItemService.getById(id);

        model.addAttribute("orderItem", orderItem);

        return "orderItem/edit";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        OrderItem orderItem = this.orderItemService.getById(id);

        model.addAttribute("orderItem", orderItem);

        return "orderItem/view";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute OrderItem orderItem) {
        this.orderItemService.edit(id, orderItem);
        return "redirect:/orderItem/";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        this.orderItemService.hapus(id);
        return "redirect:/orderItem/";
    }

}