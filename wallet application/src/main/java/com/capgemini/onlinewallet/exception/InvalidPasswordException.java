package com.capgemini.onlinewallet.exception;

public class InvalidPasswordException extends RuntimeException {
	public InvalidPasswordException(String msg) {
		super(msg);
	}

}
