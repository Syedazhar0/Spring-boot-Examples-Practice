package com.tcs.demo3microservice.Apiexception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiStatus {
    private String message;
    private boolean success;
    private HttpStatus httpStatus;
}
