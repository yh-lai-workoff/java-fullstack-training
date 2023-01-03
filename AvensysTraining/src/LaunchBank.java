import java.util.ArrayList;
import java.util.Scanner;

class InvalidAgeException extends Exception {
	public String getMessage() {
		return "You are too young to drive!";
	}
}

class Applicant {
	int age;

	void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your age:");
		age = sc.nextInt();
	}

	void verify() throws InvalidAgeException {
		if (age >= 18) {
			System.out.println("Proceed.");
		} else {
			throw new InvalidAgeException();
		}
	}
}

class Rto {
	void initiate() {
		Applicant a = new Applicant();
		try {
			a.acceptInput();
			a.verify();
		} catch (InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
	}
}

class AccountLockedException extends Exception {
	public String getMessage() {
		return "The account has been locked";
	}
}

class InvalidLoginException extends Exception {
	public String getMessage() {
		return "Login attemp is invalid.";
	}
}

class Bank {
	void loginAttempt (String username, String password) {
		try {
			tryLogin();
			System.out.println("Withdraw Money");
		} catch (InvalidLoginException e) {
			try {
				tryLogin();
				System.out.println("Withdraw Money");
			} catch (InvalidLoginException e1) {
				try {
					tryLogin();
					System.out.println("Withdraw Money");
				} catch (InvalidLoginException e2) {
					
				}
			}
		}
	}
	
	private void tryLogin() throws InvalidLoginException {
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		String password = sc.next();
		if (username.equals("username") && password.equals("password"))
			return;
		else
			throw new InvalidLoginException();
		
	}
	
	private void tryLogin(String username, String password) throws InvalidLoginException {
		if (username.equals("username") && password.equals("password"))
			return;
		else
			throw new InvalidLoginException();
	}
}



public class LaunchBank {
	public static void main(String[] args) {
		Bank dbs = new Bank();
		
		

	}
}
