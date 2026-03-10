package com.merge.exceptions;


public class ProfileNotFullException extends RuntimeException {
    public ProfileNotFullException(String message) {
        super(message);
    }
    public ProfileNotFullException() {
        super("Profile has missing required fields to save.");
    }
}
