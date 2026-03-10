package com.merge.services;

import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.nio.file.*;
import java.io.File;

public class ConfigurationsLoaderService {
    private File configurationFile;


    public ConfigurationsLoaderService(File configurationFile) {
        this.configurationFile = configurationFile;
    }

    public HashMap getAllProperties() {
        try {
            String configFileFullPath = this.configurationFile.getAbsolutePath();
            Path configFilePath = Paths.get(configFileFullPath);
            List<String> lines = Files.readAllLines(configFilePath);

            HashMap <String, String> configurations = new HashMap();
            int lineCounter = 0;
            for (String line : lines) {
                lineCounter++;
                String[] pairs = line.splitWithDelimiters(":", 2); // max divided into two parts
                if (line.startsWith("#")) {
                    continue;
                }
                if (pairs.length != 2) {
                    System.err.println("Error occured reading configuration file on line " + lineCounter);
                    continue;
                }
                configurations.put(pairs[0], pairs[1]);
            }
            return configurations;
        }
        catch (IOException e) {
            System.err.println("Failed to read configuration from configuration file.");
            throw new RuntimeException("Failed to read configuration from configuration file.");
        }
    }

    public Object get(String key) {
        HashMap configurations = this.getAllProperties();
        return configurations.get(key);
    }
}
