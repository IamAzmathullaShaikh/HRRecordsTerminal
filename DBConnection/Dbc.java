package com.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbc {
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Read environment variables if present (for Docker), fallback to defaults
            String host = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "db";
            String port = System.getenv("DB_PORT") != null ? System.getenv("DB_PORT") : "3306";
            String dbName = System.getenv("DB_NAME") != null ? System.getenv("DB_NAME") : "Organization";
            String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
            String pass = System.getenv("DB_PASS") != null ? System.getenv("DB_PASS") : "root";

            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName 
                       + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            
            con = DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return con;
    }
}