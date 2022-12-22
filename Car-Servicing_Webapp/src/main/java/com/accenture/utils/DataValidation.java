package com.accenture.utils;

import java.util.regex.Pattern;

public class DataValidation {
	private final static String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	private final static String EMAIL_REGEX = "^[\\w-]+\\@[\\w-]+(\\.[a-z]+)+$";
	
	public static boolean validatePassword(String password) {
		return password.matches(PASSWORD_REGEX);
	}
	
	public static boolean validateEmail(String email) {
		return email.matches(EMAIL_REGEX);
	}
	
	
}
