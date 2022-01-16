package com.usermanagement;

public class InvalidPasswordException extends Exception{
	public InvalidPasswordException(String errMsg) {
		super(errMsg);
	}
}
