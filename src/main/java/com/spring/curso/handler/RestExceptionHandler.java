package com.spring.curso.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.curso.error.ResourceNotFoundDetails;
import com.spring.curso.error.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
		ResourceNotFoundDetails details = ResourceNotFoundDetails.Builder
				.newBuilder()
				.timestamp(new Date().getTime())
				.status(HttpStatus.NOT_FOUND.value())
				.title("Resourse not found")
				.details(resourceNotFoundException.getMessage())
				.developerMessage(resourceNotFoundException.getClass().getName())
				.build();
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
}
