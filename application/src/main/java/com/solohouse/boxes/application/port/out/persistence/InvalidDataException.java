package com.solohouse.boxes.application.port.out.persistence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvalidDataException extends RuntimeException {


    private final String message;

    @Override
    public String getMessage() {
        return this.message;
    }
}
