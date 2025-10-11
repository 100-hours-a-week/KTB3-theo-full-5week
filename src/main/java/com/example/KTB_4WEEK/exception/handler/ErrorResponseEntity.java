package com.example.KTB_4WEEK.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponseEntity {
    private int code;
    private HttpStatus status;
    private String message;
    private String path;

    public ErrorResponseEntity(int code, HttpStatus status, String message, String path) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.path = path;

    }

    public static ResponseEntity<ErrorResponseEntity> toResponseEntity(ErrorCode e, String path) {
        ErrorResponseEntity errorResponse = new ErrorResponseEntity(e.getCode(), e.getStatus(), e.getMessage(), path);
        return ResponseEntity.status(e.getStatus())
                .body(errorResponse);
    }

    public int getCode() {
        return this.code;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPath() {
        return path;
    }
}
