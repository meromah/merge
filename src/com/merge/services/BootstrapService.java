package com.merge.services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.util.Properties;
import com.merge.services.Service;

public class BootstrapService extends Service {
    private final Path homePath = Paths.get(System.getProperty("user.home"));
    private final Path appPath;
    private final Path configPath;

    public BootstrapService() {
        // check if appPath exists, or create
        this.appPath = Paths.get(homePath.toString(), ".Merge");
        if (!Files.exists(this.appPath)) {
            try {
                Files.createDirectories(appPath);
            }
            catch (IOException e) {
                String errorMessage = "Failed to created app directory.";
                System.err.println(errorMessage);
                throw new RuntimeException(errorMessage);
            }
        }
        // check if configPath exists, or else create
        this.configPath = Paths.get(this.appPath.toString(), "config.properties");
        if (!Files.exists(this.configPath)) {
            try {
                Files.createFile(configPath);
            }
            catch (IOException e) {
                String errorMessage = "Failed to created app config file.";
                System.err.println(errorMessage);
                throw new RuntimeException(errorMessage);
            }
        }
    }

    public Path getAppPath() {
        return this.appPath;
    }

    public Path getHomePath() {
        return this.homePath;
    }

    public Path getConfigPath() {
        return this.configPath;
    }

    public Properties getConfig() {
        try {
            Properties config = new Properties();
            config.load(new FileInputStream(new File(configPath.toString())));
            // write initial configurations
            config.setProperty("sqlite.url", "jdbc:sqlite:" + Paths.get(this.appPath.toString(), "data.db").toString());
            return config;
        }
        catch (IOException e) {
            System.err.println("Failed to read properties.");
            throw new RuntimeException("Failed to read properties in App class line 24.");
        }
    }
}
