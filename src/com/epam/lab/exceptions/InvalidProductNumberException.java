package com.epam.lab.exceptions;

public class InvalidProductNumberException extends Exception {

    private static final String ERROR_MESSAGE = "Exception occurred. Not existing PRODUCT number.";

    public InvalidProductNumberException() {
        super(ERROR_MESSAGE);
    }
}
