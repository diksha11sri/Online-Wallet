package com.capgemini.onlinewallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({LowBalanceException.class, InvalidAccountException.class, UserNotFoundException.class, UserAlreadyExists.class, InvalidPasswordException.class})
	public ResponseEntity<String> handleException(Exception ex){
		
		if(ex instanceof LowBalanceException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<String>("Low Balance: ", status);
		}
		else if(ex instanceof InvalidAccountException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity<String>("Invalid Recipient Account", status);
		}
		else if(ex instanceof UserNotFoundException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity<String>("Invalid User", status);
		}
		else if(ex instanceof UserAlreadyExists) {
			HttpStatus status = HttpStatus.ALREADY_REPORTED;
			return new ResponseEntity<String>("Already User Present", status);
		}
		else if(ex instanceof InvalidPasswordException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity<String>("Invalid Password", status);
		}
		else {
			return null;
		}
	}
}