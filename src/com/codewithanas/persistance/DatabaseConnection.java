package com.codewithanas.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection(String url, String username, String password, String driver) throws SQLException {
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance(String url, String username, String password, String driver) throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection(url, username, password, driver);
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection(url, username, password, driver);
        }
        return instance;
    }

    public static DatabaseConnection getInstance(){
        return instance;
    }
    
}