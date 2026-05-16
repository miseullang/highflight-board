package com.study.highFlight.common.config.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException customException) {
        ErrorCode errorCode = customException.getErrorCode();

        Map<String, Object> response = new HashMap<>();
        response.put("err_status", errorCode.getStatus().value());
        response.put("err_message", errorCode.getMessage());

        return new ResponseEntity<>(response, errorCode.getStatus());
    }
}
