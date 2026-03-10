package com.merge.model;

import java.time.ZonedDateTime;

public class Contact {
    private String publicKey;
    private String name;
    private ZonedDateTime lastOnline;
    private String bio;

    // getters and setters
    public String getPublicKey() {
        return this.publicKey;
    }

    public String getName() {
        return this.name;
    }

    public ZonedDateTime getLastOnline() {
        return this.lastOnline;
    }

    public String getBio() {
        return this.bio;
    }

    public void setPublicKey(String newPublicKey) {
        this.publicKey = newPublicKey;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setLastOnline(ZonedDateTime newLastOnlineTimestamp) {
        this.lastOnline = newLastOnlineTimestamp;
    }

    public void setBio(String newBio) {
        this.bio = newBio;
    }
}
