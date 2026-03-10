package com.merge.controllers;

import com.merge.services.BootstrapService;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.sql.Connection;
import com.merge.services.SQLiteService;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class App {
    public static void run() {

        BootstrapService bootstrap = new BootstrapService();
        Path configPath = bootstrap.getConfigPath();

        Properties config = bootstrap.getConfig();

        Connection connection = SQLiteService.getConnection(config);
        System.exit(0);
    }
}
