package com.data.session_05.controller;

import com.data.session_05.model.Product;
import com.data.session_05.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ModelAndView showProductList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        List<Product> products = productService.getProducts(page, size);
        int total = productService.countProducts();
        int totalPages = (int) Math.ceil((double) total / size);

        ModelAndView mv = new ModelAndView("product-list");
        mv.addObject("products", products);
        mv.addObject("currentPage", page);
        mv.addObject("totalPages", totalPages);
        return mv;
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id){
        productService.addToCart(id);
        return "redirect:/home";
    }
}
