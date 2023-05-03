package org.example.error;

public class SongValidationException extends Exception {
    public SongValidationException(String message) {
        super(message);
    }
}
