package com.amachi.app.hospitalappservice.common.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String error;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(Exception ex) {
        this.error = ex.getClass().getCanonicalName();
        this.message = ex.getMessage();
        this.timestamp = LocalDateTime.now();
    }
}
