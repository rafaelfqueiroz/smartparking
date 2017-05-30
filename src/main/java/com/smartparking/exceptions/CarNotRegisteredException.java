package com.smartparking.exceptions;

public class CarNotRegisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CarNotRegisteredException() {
		this("Carro não registrado.");
	}
	
	public CarNotRegisteredException(String message) {
		super(message);
	}
}
