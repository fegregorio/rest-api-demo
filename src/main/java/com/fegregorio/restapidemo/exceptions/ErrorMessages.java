package com.fegregorio.restapidemo.exceptions;

public enum ErrorMessages {

    ID_NOT_FOUND_MESSAGE("Id not found."),
    EMPTY_RESPONSE_LIST_MESSAGE("Address list is empty.");


    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
