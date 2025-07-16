package com.data.session_05.repository;

import com.data.session_05.model.ProductCart;
import com.data.session_05.utils.Database;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductCartRepository {
    public List<ProductCart> findAll() {
        List<ProductCart> list = new ArrayList<>();
        String sql = "SELECT pc.id, p.product_name, p.price, pc.quantity " +
                "FROM product_cart pc JOIN product p ON pc.product_id = p.id";
        try{
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ProductCart cart = new ProductCart();
                cart.setId(rs.getInt("id"));
                cart.setProductName(rs.getString("product_name"));
                cart.setPrice(rs.getDouble("price"));
                cart.setQuantity(rs.getInt("quantity"));
                list.add(cart);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void updateQuantity(int id, int quantity){
        String sql = "UPDATE product_cart SET quantity = ? WHERE id = ?";
        try{
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quantity);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM product_cart WHERE id = ?";
        try{
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public double getTotal(){
        String sql = "SELECT SUM(p.price * pc.quantity) AS total FROM product_cart pc JOIN product p ON pc.product_id = p.id";
        try{
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getDouble("total");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
