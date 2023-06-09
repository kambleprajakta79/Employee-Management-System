package com.api.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class DataExceptionController {
	
	@ExceptionHandler(value=DataNotFoundException.class)
	public ResponseEntity<Object> exception (DataNotFoundException exception)
	{
		return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
	}

}
