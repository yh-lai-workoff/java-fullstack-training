package parallel;

import java.util.Scanner;

class Demo extends Thread{
	public void run() {
		if (getName().equals("TEST1")) {
			banking();
		} else if (getName().equals("PRINTING")) {
			try {
				printing();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			addition();
		}
	}
	
	void banking() {
		System.out.println("Banking start");
		Scanner sc = new Scanner(System.in);
		System.out.println("Account Number Input:");
		int an = sc.nextInt();
		System.out.println("Password Input:");
		int pw = sc.nextInt();
		System.out.println("Banking Ends");
	}
	
	void printing() throws InterruptedException {
		System.out.println("Printing start");
		for(int i=0; i <10; i++) {
			System.out.println("Yes! "+i);
			Thread.sleep(3000);
		}
		System.out.println("Printing ends");
	}
	void addition() {
		System.out.println("Addition start");
		int a= 0;
		int b= 0;
		for (int x = 0; x<20; x++) {
			a++;
			b+= a;
		}
		System.out.println("Addition ends");
	}
}

public class LaunchDemo {
	public static void main(String[] args) {
		Demo d1 = new Demo();
		d1.setName("TEST1");
		Demo d2 = new Demo();
		d2.setName("PRINTING");
		Demo d3 = new Demo();
		
		d1.start();
		d2.start();
		d3.start();
	}
}
