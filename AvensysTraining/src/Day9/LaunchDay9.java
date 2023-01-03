package Day9;

import java.util.Random;

@FunctionalInterface
interface MyFunctionalInterface {
	void add();

}

@FunctionalInterface
interface CalculatorInterface {
	void operatorTwo(int a, int b);
}

class Class2 implements MyFunctionalInterface {
	public void add() {
		System.out.println("4222");
	}
}

/*
 * 1) Delete Access Modifiers, Return Type, Method Signature
 * 
 * () {System.out.println("4222")}
 * 
 * 2) Add Lambda Indicator ( ->)
 * 
 * () -> {System.out.println("4222")}
 * 
 * 3) Optionally remove curly braces since it's single line (Can keep for
 * multi-line)
 * 
 * () -> System.out.println("4222");
 */

public class LaunchDay9 {
	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.nextInt(0, 20));
		
		MyFunctionalInterface f = () -> System.out.println("4222");
		CalculatorInterface cf = (a, b) -> System.out.println(a + b);
		cf.operatorTwo(10, 20);
		cf = (int a, int b) -> System.out.println(a * b);
	}
}
