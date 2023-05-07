package org.example.error;

public class ArtistNotFoundException extends Exception {
    public ArtistNotFoundException(String message) {
        super(message);
    }
}
