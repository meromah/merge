package com.merge.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.merge.services.Service;
import java.util.Properties;

public class SQLiteService extends Service {

    public static Connection getConnection(Properties config) {
        try {
            Connection connection = DriverManager.getConnection(
                config.getProperty("sqlite.url")
            );
            System.out.println("Connection to SQLite has been established.");
            return connection;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Connection with SQLlite failed.");
        }
    }
}
