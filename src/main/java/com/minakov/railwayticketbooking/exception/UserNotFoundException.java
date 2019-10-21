package com.minakov.railwayticketbooking.exception;

import java.util.UUID;

public class UserNotFoundException extends Throwable {

    private String message;

    public UserNotFoundException(UUID userId) {
        this.message = "User with id " + userId + " not found";
    }

    public UserNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
