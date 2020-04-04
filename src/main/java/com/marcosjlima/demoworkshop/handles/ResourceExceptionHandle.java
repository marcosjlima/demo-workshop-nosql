package com.marcosjlima.demoworkshop.handles;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcosjlima.demoworkshop.exceptions.DataBaseException;
import com.marcosjlima.demoworkshop.exceptions.ResourceNotFoundException;
import com.marcosjlima.demoworkshop.exceptions.StandarError;

@ControllerAdvice
public class ResourceExceptionHandle {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandarError standarError = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(standarError);
	}
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandarError> dataBase(DataBaseException e, HttpServletRequest request) {
		String error = "Database error!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandarError standarError = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(standarError);
	}
}
