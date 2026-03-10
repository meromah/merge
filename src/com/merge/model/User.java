package com.merge.model;

import java.util.Properties;
import com.merge.exception.ProfileNotFoundException;
import com.merge.exception.ProfileNotFullException;
import java.security.PublicKey;
import com.merge.model.Address;
import java.time.ZonedDateTime;

public class User {
    private String name;
    private Address address;
    private String bio;
    private final Properties config;
    private PublicKey publicKey;
    private ZonedDateTime lastOnline;
    // add hashid or private key signaure when private key is set
    // upon save method save this to db
    // create db table users with the given fields
    // UUID instead of RSA signature?

    public User(String name, String bio, Properties config) {
        this.name = name;
        this.bio = bio;
        this.config = config;
    }

    // public static User load(Properties config) {
    //     String name = config.getProperty("profile.name");
    //     String bio = config.getProperty("profile.bio");
    //     if (name == null || name.isBlank()) {
    //         throw new ProfileNotFoundException();
    //     }
    //     return new User(name, bio, config);
    // }

    public String getName() { return this.name; }
    public String getBio() { return this.bio; }
    public Address getAddress() {return this.address;}
    public PublicKey getPublicKey() {return this.publicKey;}
    public ZonedDateTime getLastOnline() {return this.lastOnline;}

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public User setAddress(Address address) {
        this.address = address;
        return this;
    }

    public User setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public User setLastOnline(ZonedDateTime lastOnline) {
        this.lastOnline = lastOnline;
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
