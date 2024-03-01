package com.skbit.userservice.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.skbit.userservice.exception.payload.apiResponse;

@RestControllerAdvice
public class GobleExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<apiResponse> HandlerResourceNotFoundException(ResourceNotFoundException exception){
		String message = exception.getMessage();
		apiResponse response = apiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
  
		return new ResponseEntity<apiResponse>(response,HttpStatus.NOT_FOUND);
	}
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap();
	        ex.getBindingResult().getAllErrors().forEach(error -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	    }
	 
	
	 @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<String> UserNotFoundException(UserNotFoundException ex) {
	            String message = ex.getMessage();
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	    }
	
}
