package day10;

import java.util.InputMismatchException;
import java.util.Scanner;

class InheritedException extends Exception{
	public String getMessage() {
		return "Can you fix this thing?";
	}
}
final class test{
	
}

class Demo1{
	void notFun1() throws Exception{
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Numerator:");
			int a = sc.nextInt();
			System.out.println("Denominator:");
			int b = sc.nextInt();
			int c = a/b;
			System.out.println(c);
		}
		catch (ArithmeticException e) {
			System.out.println("Please enter non-zero Denominator");
			throw e;
		}
		catch (Exception e) {
			System.out.println("Unknown Exception Caught in Demo1, Throwing");
			throw e;
		}
	}
}

class Demo2{
	void fun2() throws Exception{
		try {
			Demo1 d1 = new Demo1();
			d1.notFun1();
		}
		catch (ArithmeticException e) {
			System.out.println("Please enter non-zero Denominator");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Please enter valid index");
		}
		catch(Exception e) {
			System.out.println("Unknown Exception Caught in Demo2, Throwing");
			throw e;
		}
		
	}
}

class Demo3{
	void notFunny() throws Exception {
		try {
			Demo2 d2 = new Demo2();
			d2.fun2();
		}
		catch (Exception e) {
			System.out.println("We don't talk about 3");
			throw e;
		}
		
	}
}

class Demo4 {
	void great() throws Exception {
		try {
			Demo3 d3 = new Demo3();
			d3.notFunny();
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter a valid Integer");
		}
		
		catch(Exception e) {
			System.out.println("Cannot down cast exception?");
			throw e;
		}
		
	}
	
	void superb() throws InputMismatchException, InheritedException{
		try {
			Demo3 d3 = new Demo3();
			d3.notFunny();
		}
		catch(InputMismatchException e) {
			try {
				Demo1 d1 = new Demo1();
				d1.notFun1();
			}
			catch (Exception e2) {
				throw new InheritedException();
			}
		}
		catch (Exception e) {
			System.out.println("Nothing I can do lol");
		}
	}
}

public class ExceptionExample {
	public static void main(String[] args) {
		System.out.println("Connection Open");
		try {
			
			Demo4 d4 = new Demo4();
			d4.superb();
		}
		catch(NegativeArraySizeException e) {
			System.out.println("Please enter an index > 0");
		}
		catch(ArrayStoreException e) {
			System.out.println("Please enter only int data");
		}
		catch (Exception e) {
			System.out.println("Unknown Error has occurred, please contact your system administrator for assistance.");
			System.out.println(e.getMessage());;
		}
		finally {
			System.out.println("Connection Closed");
		}
		System.out.println();
	}
}
