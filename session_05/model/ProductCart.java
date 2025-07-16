package com.data.session_05.model;

public class ProductCart {
    private int id;
    private int productId;
    private int quantity;

    // Extra fields
    private String productName;
    private double price;

    public ProductCart() {
    }

    public ProductCart(int id, int productId, int quantity, String productName, double price) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
