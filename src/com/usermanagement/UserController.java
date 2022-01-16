package com.usermanagement;

public class UserController {

	public static void main(String[] args) {
		UserService userService = new UserService();
		userService.addUsers();
	}

}
