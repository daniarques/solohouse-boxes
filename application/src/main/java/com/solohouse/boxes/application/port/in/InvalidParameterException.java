package com.solohouse.boxes.application.port.in;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvalidParameterException extends Exception {

    private final String message;

    @Override
    public String getMessage() {
        return this.message;
    }
}
