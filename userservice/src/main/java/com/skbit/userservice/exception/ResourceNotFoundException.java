package com.skbit.userservice.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		super("Resorce Not found on Server");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
