package ru.nshi.error;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
