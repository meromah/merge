package com.merge.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.merge.services.Service;
import java.util.Properties;

public class SQLiteService extends Service {
    private final Connection connection;

    public SQLiteService(Properties config) {
        try {
            this.connection = DriverManager.getConnection(
                config.getProperty("sqlite.url")
            );
            System.out.println("Connection to SQLite has been established.");
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Connection with SQLlite failed.");
        }
    }
    public Connection getConnection() {
        System.out.println("Connection to SQLite has been returned.");
        return this.connection;
    }

    public void closeConnection() {
        try {
            if (this.connection != null || !this.connection.isClosed()) {
                connection.close();
                System.out.println("Connection to sqlite has been closed.");
            }
        }
        catch (SQLException e) {
            System.err.printf("Failed closing connection: %s", e.getMessage());
            throw new RuntimeException(
                "Failed trying to close connection with sqlite."
            );
        }
    }
}
