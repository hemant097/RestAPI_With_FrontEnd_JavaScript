package com.masai.exceptions;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	//to handle our specific exception
	@ExceptionHandler(BookNotFound.class)
	public ResponseEntity<MyCustomError> myHandler(BookNotFound ie,WebRequest wr) {
	
		MyCustomError mce = new MyCustomError();
		
		mce.setTimestamp(LocalDateTime.now());
		mce.setMessage(ie.getMessage());
		mce.setDetails(wr.getDescription(false));
	
	return new ResponseEntity<MyCustomError>( mce,HttpStatus.CONFLICT);
	}
	
	/*TO use 'NoHandlerFoundException' place these 2 lines in
	 * application properties file
	 * 
	 * spring.mvc.throw-exception-if-no-handler-found=true
		spring.web.resources.add-mappings=false

	 * */
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyCustomError> myHandler2(MethodArgumentNotValidException ie) {
	
		System.out.println("inside myHandler3 method...");
		MyCustomError mce = new MyCustomError();
		
		mce.setTimestamp(LocalDateTime.now());
		mce.setMessage("Check the constraint size");
		mce.setDetails(ie.getBindingResult().getFieldError().getDefaultMessage());
	
	return new ResponseEntity<>(mce,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	//to handle the incorrect uri 
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyCustomError> NoHandlerFound(NoHandlerFoundException ie,WebRequest wr) {
	
		System.out.println("inside NoHandlerFound method...");
		MyCustomError mce = new MyCustomError();
		
		mce.setTimestamp(LocalDateTime.now());
		mce.setMessage(ie.getMessage());
		mce.setDetails(wr.getDescription(false));
	
	return new ResponseEntity<MyCustomError>(mce,HttpStatus.BAD_REQUEST);
	}
		
	
	//below method to handle all other exceptions	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyCustomError> ultimateHandler(Exception ie,WebRequest wr) {
	
		System.out.println("inside ultimateHandler method...");
		
		MyCustomError err = new MyCustomError(
							LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyCustomError>(err,HttpStatus.BAD_REQUEST);
	}
	
}
