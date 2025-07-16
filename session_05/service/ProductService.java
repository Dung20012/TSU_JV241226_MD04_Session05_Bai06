package com.data.session_05.service;

import com.data.session_05.model.Product;
import com.data.session_05.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(int page, int size) {
        int offset = (page - 1) * size;
        return productRepository.getProducts(offset, size);
    }

    public int countProducts(){
        return productRepository.countProducts();
    }

    public void addToCart(int productId){
        productRepository.addToCart(productId);
    }
}
