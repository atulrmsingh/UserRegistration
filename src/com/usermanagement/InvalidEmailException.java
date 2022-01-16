package com.usermanagement;

public class InvalidEmailException extends Exception{
	public InvalidEmailException(String errMsg) {
		super(errMsg);
	}
}
