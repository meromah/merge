package com.merge.exception;


public class ProfileNotFullException extends RuntimeException {
    public ProfileNotFullException(String message) {
        super(message);
    }
    public ProfileNotFullException() {
        super("Profile has missing required fields to save.");
    }
}
