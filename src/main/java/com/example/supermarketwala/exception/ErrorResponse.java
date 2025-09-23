package com.example.supermarketwala.exception;

public record ErrorResponse(
		String timestamp, // date and time
		int status, // status code
		String error, // Error : main
		String message, // detailing of the error
		String path // exact location of the error
		) {}
