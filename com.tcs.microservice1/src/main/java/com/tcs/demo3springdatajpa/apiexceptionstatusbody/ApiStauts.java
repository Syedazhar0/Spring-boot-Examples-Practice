package com.tcs.demo3springdatajpa.apiexceptionstatusbody;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiStauts {
	
	private String message;
	private boolean success;
	private HttpStatus status;

}
