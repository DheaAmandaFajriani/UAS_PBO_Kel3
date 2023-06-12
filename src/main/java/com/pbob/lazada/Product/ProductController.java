package com.pbob.lazada.Product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.pbob.lazada.ProductCategory.Category;
import com.pbob.lazada.ProductCategory.CategoryService;

/**
 * ProductController
 */
@Controller
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;
    

    @Autowired
    public ProductController(ProductService productService,) {
        this.productService = productService;
        
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<Product> dataProduct = this.productService.getAll();
        model.addAttribute("dataProduct", dataProduct);
        return "product/index";
    }

    @GetMapping("/tambah")
    public String form_tambah(Model model) {
        return "product/tambah";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Product product) {
        this.productService.simpan(product);
        return "redirect:/product/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Product product = this.productService.getById(id);

        model.addAttribute("product", product);

        return "product/edit";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Product product = this.productService.getById(id);

        model.addAttribute("product", product);

        return "product/view";
    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Product product) {
        this.productService.edit(id, product);
        return "redirect:/product/";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        this.productService.hapus(id);
        return "redirect:/product/";
    }
}