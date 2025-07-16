package com.data.session_05.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        }catch (ClassCastException e){
            System.err.println("Driver not found: "+e.getMessage());
        }catch (SQLException e){
            System.err.println("Connection faild: "+e.getMessage());
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Failed to close connection: "+e.getMessage());
            }
        }
    }
}
