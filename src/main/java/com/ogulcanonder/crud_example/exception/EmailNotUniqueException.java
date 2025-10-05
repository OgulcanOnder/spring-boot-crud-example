package com.ogulcanonder.crud_example.exception;

public class EmailNotUniqueException extends RuntimeException {
    public EmailNotUniqueException(String message) {
        super(message);
    }
}
