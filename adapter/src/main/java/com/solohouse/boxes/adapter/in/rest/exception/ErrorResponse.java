package com.solohouse.boxes.adapter.in.rest.exception;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class ErrorResponse {

    @Builder.Default
    LocalDateTime timestamp = LocalDateTime.now();

    int status;

    String error;

    String path;

}
