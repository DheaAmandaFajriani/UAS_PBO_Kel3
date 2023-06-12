package com.pbob.lazada.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pbob.lazada.User.User;
import com.pbob.lazada.User.UserService;

/**
 * CustomerController
 */
@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final UserService userService;

    @Autowired
    public CustomerController(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<Customer> dataCustomer = this.customerService.getAll();
        List<User>userCustomer=this.userService.getAll();
        model.addAttribute("dataCustomer", dataCustomer);
        model.addAttribute("userCustomer", userCustomer);
         return "customer/index";
    }

    @GetMapping("/tambah")
    public String form_tambah(Model model) {
       List<User>userCustomer=this.userService.getAll();
        model.addAttribute("userCustomer", userCustomer);
        return "customer/tambah";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Customer customer, Model model) {
        this.customerService.simpan(customer);
        model.addAttribute("customer", customer);
        return "redirect:/customer/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Customer customer = this.customerService.getById(id);

        model.addAttribute("customer", customer);

        return "customer/edit";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Customer customer = this.customerService.getById(id);

        model.addAttribute("customer", customer);

        return "customer/view";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Customer customer) {
        this.customerService.edit(id, customer);
        return "redirect:/customer/";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        this.customerService.hapus(id);
        return "redirect:/customer/";
    }

}