package com.data.session_05.service;

import com.data.session_05.model.ProductCart;
import com.data.session_05.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCartService {

    @Autowired
    private ProductCartRepository cartRepository;

    public List<ProductCart> getAll(){
        return cartRepository.findAll();
    }

    public void updateQuantity(int id, int quantity){
        cartRepository.updateQuantity(id, quantity);
    }

    public void deleteById(int id){
        cartRepository.delete(id);
    }

    public double getTotalPrice(){
        return cartRepository.getTotal();
    }
}
