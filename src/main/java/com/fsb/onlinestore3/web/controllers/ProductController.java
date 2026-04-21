package com.fsb.onlinestore3.web.controllers;

import com.fsb.onlinestore3.web.models.Product;
import com.fsb.onlinestore3.web.models.requests.ProductForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("/products")
public class ProductController {
    private static List<Product> products = new ArrayList<>();
    private static Long idCount = 0L;

    static {
        products.add(new Product(++idCount, "SS-S26", "Samsung Galaxy S26", 4000D, 10, "SS26.png"));
        products.add(new Product(++idCount, "IP-17PM", "Iphone 17 Pro Max", 4600D, 10, "ip17pm.png"));
        products.add(new Product(++idCount, "OP-15", "One Plus 15", 2000D, 10, "op15.png"));
    }

    //Read function
    @GetMapping
    public String showProd(Model model) {
        model.addAttribute("ProdList", products);
        return "list";
    }

    //create functions
    @GetMapping("/create")
    public String createProd(Model model) {
        model.addAttribute("pForm", new ProductForm());
        return "create";
    }

    @PostMapping("/create")
    //variable fl @modelattribute t7ottou howa bidou fi HTML object *pForm*
    public String createProd(@Valid @ModelAttribute ProductForm pForm,
                             BindingResult result) {

        if (result.hasErrors()) {
            return "create";
        }

        Product p = new Product();
        p.setId(++idCount);
        p.setCode(pForm.getCode());
        p.setName(pForm.getName());
        p.setPrice(pForm.getPrice());
        p.setQuantity(pForm.getQuantity());
        p.setImg(pForm.getImg());

        products.add(p);
        return "redirect:/products";
    }

    //edit functions
    @GetMapping("/edit/{id}")
    public String editProd(@PathVariable long id, Model model) {
        Product target = findProductById(id);
        if (target == null) {
            return "redirect:/products";
        }

        ProductForm form = new ProductForm();
        form.setId(target.getId());
        form.setCode(target.getCode());
        form.setName(target.getName());
        form.setPrice(target.getPrice());
        form.setQuantity(target.getQuantity());
        form.setImg(target.getImg());

        model.addAttribute("pForm", form);
        return "update";
    }

    @PostMapping("/{id}/edit/")
    public String editProd(@Valid @ModelAttribute
                           ProductForm pForm,
                           BindingResult result) {

        if (result.hasErrors()) {
            return "update";
        }

        Product target = findProductById(pForm.getId());
        if (target == null) {
            return "redirect:/products";
        }

        target.setCode(pForm.getCode());
        target.setName(pForm.getName());
        target.setPrice(pForm.getPrice());
        target.setQuantity(pForm.getQuantity());
        target.setImg(pForm.getImg());

        return "redirect:/products";
    }

    private Product findProductById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @GetMapping("/delete/{id}")
    public String delProd(@PathVariable long id, @ModelAttribute
                          ProductForm pForm,
                          BindingResult result) {

        Product target = findProductById(id);
        products.remove(target);
        return "redirect:/products";
    }
}
