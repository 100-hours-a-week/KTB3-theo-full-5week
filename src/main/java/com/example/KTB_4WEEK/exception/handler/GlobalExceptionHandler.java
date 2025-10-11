package com.example.KTB_4WEEK.exception.handler;

import com.example.KTB_4WEEK.exception.common.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseEntity> handleBusinessException(BusinessException e, HttpServletRequest req) {
        return ErrorResponseEntity.toResponseEntity(e.getErrorCode(), req.getRequestURI());
    }
}
