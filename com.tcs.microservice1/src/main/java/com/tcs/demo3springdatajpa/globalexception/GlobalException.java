package com.tcs.demo3springdatajpa.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tcs.demo3springdatajpa.apiexceptionstatusbody.ApiStauts;
import com.tcs.demo3springdatajpa.customexception.CustomException;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ApiStauts> handleApiException(CustomException customException){
		String message = customException.getMessage();
		ApiStauts build =ApiStauts.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(build,HttpStatus.NOT_FOUND);
	}

}
