package com.epam.lab.exceptions;

public class InvalidShopNumberException extends Exception {
    private static final String ERROR_MESSAGE = "Exception occurred. Not existing SHOP number.";

    public InvalidShopNumberException() {
        super(ERROR_MESSAGE);
    }
}
