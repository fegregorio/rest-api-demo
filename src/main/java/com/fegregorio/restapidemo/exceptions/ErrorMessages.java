package com.fegregorio.restapidemo.exceptions;

public enum ErrorMessages {

    ID_NOT_FOUND("Id not found."),
    EMPTY_RESPONSE_LIST("Address list is empty."),
    DUPLICATE_EMAIL("Email already in database."),
    DUPLICATE_CPF("CPF already in database.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
