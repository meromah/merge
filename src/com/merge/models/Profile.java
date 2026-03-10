package com.merge.models;

import java.util.Properties;
import com.merge.exceptions.ProfileNotFoundException;
import com.merge.exceptions.ProfileNotFullException;

public class Profile {
    private String name;
    private String bio;
    private Properties config;

    public Profile(String name, String bio, Properties config) {
        this.name = name;
        this.bio = bio;
        this.config = config;
    }

    public static Profile load(Properties config) {
        String name = config.getProperty("profile.name");
        String bio = config.getProperty("profile.bio");
        if (name == null || name.isBlank()) {
            throw new ProfileNotFoundException();
        }
        return new Profile(name, bio, config);
    }

    public String getName() { return this.name; }
    public String getBio() { return this.bio; }

    public Profile setName(String name) {
        this.name = name;
        return this;
    }

    public Profile setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public void save() {
        if (this.name == null || this.name.isBlank()) {
            throw new ProfileNotFullException();
        }
        this.config.setProperty("profile.name", this.name);
        this.config.setProperty("profile.bio", this.bio);
    }
}
