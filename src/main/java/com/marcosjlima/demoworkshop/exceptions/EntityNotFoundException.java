package com.marcosjlima.demoworkshop.exceptions;

public class EntityNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String msg) {
		super("Entity not found! Error: " + msg);
	}
}
