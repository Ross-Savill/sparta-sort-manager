package com.sparta.rosssavill.sortmanager.util;

public class ChildNotFoundException extends Exception {

    public ChildNotFoundException() {
        super("This Node has no child in that direction.");
    }

    public ChildNotFoundException(String message) {
        super(message);
    }
}
