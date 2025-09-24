package com.example.supermarketwala.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	// construtor : 
	public NotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
