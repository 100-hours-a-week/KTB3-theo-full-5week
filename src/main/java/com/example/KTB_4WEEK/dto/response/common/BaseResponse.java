package com.example.KTB_4WEEK.dto.response.common;

import com.example.KTB_4WEEK.util.DateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseResponse<T> {
    private int status;
    private String message;
    private T data;
    private String timestamp;

    public BaseResponse() {
    }

    public BaseResponse(ResponseMessage message, T data) {
        this.status = status;
        this.message = message.getMessage();
        this.data = data;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return this.data;
    }

    public String getTimestamp() {
        return this.timestamp;
    }
}
