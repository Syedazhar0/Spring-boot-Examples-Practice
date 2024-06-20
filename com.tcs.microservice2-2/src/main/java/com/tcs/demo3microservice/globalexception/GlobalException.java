package com.tcs.demo3microservice.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tcs.demo3microservice.Apiexception.ApiStatus;
import com.tcs.demo3microservice.exceptions.RestaurantNotFoundException;

@RestControllerAdvice
public class GlobalException {
@ExceptionHandler
public ResponseEntity<ApiStatus> handleApiException(RestaurantNotFoundException exception) {
    String message = exception.getMessage();
    ApiStatus status = ApiStatus.builder()
                                .message(message)
                                .success(false)
                                .httpStatus(HttpStatus.NOT_FOUND)
                                .build();
    return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
}
}
