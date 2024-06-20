package com.tcs.demo2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tcs.demo2.customexception.ProductException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

	
	  @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
	        Map<String, Object> errorResponse = new HashMap<>();
	        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.put("message", "Internal Server Error");
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }



    @ExceptionHandler(ProductException.class)
    public ResponseEntity<Map<String, Object>> handleProductException(ProductException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}



// you can handle exception using stringBuilder 
// package com.tcs.demo2.Exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.tcs.demo2.customexception.ProductException;
//
//@RestControllerAdvice
//public class MethodArgumentNotValidExceptionHandler {
//
//    @ExceptionHandler(ProductException.class)
//    public ResponseEntity<String> handleProductException(ProductException ex) {
//        StringBuilder errorResponse = new StringBuilder();
//        errorResponse.append("status: ").append(HttpStatus.BAD_REQUEST).append(", ");
//        errorResponse.append("message: ").append(ex.getMessage());
//        return new ResponseEntity<>(errorResponse.toString(), HttpStatus.BAD_REQUEST);
//    }

    // Add more exception handlers as needed

    // Example of handling generic exceptions
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception ex) {
//        StringBuilder errorResponse = new StringBuilder();
//        errorResponse.append("status: ").append(HttpStatus.INTERNAL_SERVER_ERROR).append(", ");
//        errorResponse.append("message: ").append("Internal Server Error");
//        return new ResponseEntity<>(errorResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}



