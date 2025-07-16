package com.data.session_05.controller;

import com.data.session_05.model.ProductCart;
import com.data.session_05.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private ProductCartService cartService;

    // Hiển thị giỏ hàng
    @GetMapping("")
    public ModelAndView showCart(){
        List<ProductCart> carts = cartService.getAll();
        double total = cartService.getTotalPrice();
        ModelAndView modelAndView = new ModelAndView("cart-list");
        modelAndView.addObject("carts", carts);
        modelAndView.addObject("total", total);
        return modelAndView;
    }

    // Cập nhật số lượng sản phẩm
    @PostMapping("/update/{id}")
    public String updateCart(@PathVariable int id, @RequestParam int quantity) {
        cartService.updateQuantity(id, quantity);
        return "redirect:/carts";
    }

    // Xóa sản phẩm khỏi giỏ hàng
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id) {
        cartService.deleteById(id);
        return "redirect:/carts";
    }
}
