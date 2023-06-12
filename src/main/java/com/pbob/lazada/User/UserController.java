package com.pbob.lazada.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pbob.lazada.Customer.Customer;
import com.pbob.lazada.Customer.CustomerService;
//import com.pbob.lazada.Product.Product;

/**
 * UserController
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;
    private final CustomerService customerService;

    @Autowired
    public UserController(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<User> dataUser = this.userService.getAll();
        model.addAttribute("dataUser", dataUser);
        return "user/index";
    }

    @GetMapping("/tambah")
    public String form_tambah(Model model) {
        return "user/tambah";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute User user) {
        this.userService.simpan(user);
        return "redirect:/user/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        User user = this.userService.getById(id);
        
        model.addAttribute("user", user);

        return "user/edit";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        User user = this.userService.getById(id);
        model.addAttribute("user", user);
        Customer customer = this.customerService.getById(id);
        model.addAttribute("customer", customer);
        return "user/view";
    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute User user) {
        this.userService.edit(id, user);
        return "redirect:/user/";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        this.userService.hapus(id);
        return "redirect:/user/";
    }

      @GetMapping("/tambahdata/{id}")
    public String tambahdata(@PathVariable Long id, Model model) {
        User user = this.userService.getById(id);
        model.addAttribute("user", user);
        Customer customer = this.customerService.getById(id);
        model.addAttribute("customer", customer);
        return "product/tambahdata";
    }
}