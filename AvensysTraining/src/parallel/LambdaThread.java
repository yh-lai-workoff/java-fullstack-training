package parallel;

import java.util.Iterator;
import java.util.Scanner;

public class LambdaThread {
	public static void main(String[] args) {
		shortRun();
	}
	public static void longRun() {
		Demo1 d1 = new Demo1();
		Demo2 d2 = new Demo2();
		Demo3 d3 = new Demo3();
		
		Thread t1 = new Thread (d1);
		Thread t2 = new Thread(d2);
		Thread t3 = new Thread(d3);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void shortRun() {
		new Thread( () ->{
			System.out.println("Banking Start");
			Scanner scan = new Scanner(System.in);
			System.out.println("Account number");
			int an = scan.nextInt();
			System.out.println("Account PW");
			int pw = scan.nextInt();
			System.out.println("Collect your money\nBanking activity completed");
		}).start();
		
		new Thread(()->{
			try {
				System.out.println("Printing Start");
				for (int i=0; i <5; i++) {
					System.out.println("ABC");
					Thread.sleep(2000);
				}
				System.out.println("Printing activity completed");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}).start();
		
		new Thread(()->{
			System.out.println("Adding start");
			int a = 10;
			int b = 20;
			int c = a+b;
			System.out.println(c+"\nAdding End");
		}).start();
	}

}


class Demo1 implements Runnable{
	public void run() {
		System.out.println("Banking Start");
		Scanner scan = new Scanner(System.in);
		System.out.println("Account number");
		int an = scan.nextInt();
		System.out.println("Account PW");
		int pw = scan.nextInt();
		System.out.println("Collect your money");
		System.out.println("Banking activity completed");
	}
}

class Demo2 implements Runnable{
	public void run() {
		try {
			System.out.println("Printing Start");
			for (int i=0; i <5; i++) {
				System.out.println("ABC");
				Thread.sleep(2000);
			}
			System.out.println("Printing activity completed");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

class Demo3 implements Runnable{
	public void run() {
		System.out.println("Adding start");
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println(c);
		System.out.println("Adding End");
	}
}



