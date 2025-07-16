package com.data.session_05.repository;

import com.data.session_05.model.Product;
import com.data.session_05.utils.Database;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> getProducts(int offset, int limit){
        List<Product> list = new ArrayList<>();
        String sql = "select * from product limit ? offset ?";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, limit);
            stmt.setInt(2, offset);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                product.setDescription(rs.getString("description"));
                list.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public int countProducts(){
        String sql = "select count(*) from product";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void addToCart(int productId){
        String checkSql = "SELECT id, quantity FROM product_cart WHERE product_id = ?";
        String insertSql = "INSERT INTO product_cart (product_id, quantity) VALUES (?, ?)";
        String updateSql = "UPDATE product_cart SET quantity = quantity + 1 WHERE id = ?";

        try {
            Connection conn = Database.getConnection();

            // Kiểm tra sản phẩm đã có trong giỏ chưa
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, productId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Đã có => tăng số lượng
                int cartId = rs.getInt("id");
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setInt(1, cartId);
                updateStmt.executeUpdate();
            } else {
                // Chưa có => insert mới
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setInt(1, productId);
                insertStmt.setInt(2, 1); // số lượng mặc định = 1
                insertStmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
