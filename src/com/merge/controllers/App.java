package com.merge.controllers;

import com.merge.services.BootstrapService;
import java.sql.Connection;
import com.merge.services.SQLiteService;
import java.util.Properties;

public class App {
    public static void run() {

        try {
            BootstrapService bootstrap = new BootstrapService();

            Properties config = bootstrap.getConfig();

            SQLiteService dbService = new SQLiteService(config);
            Connection connection = dbService.getConnection();
            dbService.close();
        }
        catch (Exception e) {
            System.err.printf("Something went wrong: %o", e.getMessage());
            System.exit(1);
        }
        System.exit(0);
    }
}
