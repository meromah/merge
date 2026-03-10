package com.merge.models;

import java.util.Properties;
import com.merge.exceptions.UserNotFoundException;
import com.merge.exceptions.UserNotFullException;

public class User {
    private String name;
    private String bio;
    private Properties config;

    public User(String name, String bio, Properties config) {
        this.name = name;
        this.bio = bio;
        this.config = config;
    }

    public static User load(Properties config) {
        String name = config.getProperty("profile.name");
        String bio = config.getProperty("profile.bio");
        if (name == null || name.isBlank()) {
            throw new UserNotFoundException();
        }
        return new User(name, bio, config);
    }

    public String getName() { return this.name; }
    public String getBio() { return this.bio; }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public void save() {
        if (this.name == null || this.name.isBlank()) {
            throw new UserNotFullException();
        }
        this.config.setProperty("profile.name", this.name);
        this.config.setProperty("profile.bio", this.bio);
    }
}
