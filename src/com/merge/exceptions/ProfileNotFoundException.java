package com.merge.exceptions;


public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String message) {
        super(message);
    }
    public ProfileNotFoundException() {
        super("Profile has not been found in the config.");
    }
}
