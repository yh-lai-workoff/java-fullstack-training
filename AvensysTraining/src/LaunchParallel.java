import java.util.Scanner;

class Demo1 extends Thread {
	public void run(){
		try {
			LaunchParallel.Printer.printing();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Dem2 extends Thread {
	public void run(){
		try {
			LaunchParallel.Printer.printing();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class D2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			LaunchParallel.Printer.printing();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Demo3 extends Thread {
	public void run(){
		
		LaunchParallel.Adder.addition();
		
	}
}

public class LaunchParallel {
	public static void main(String[] args) {
		try {
			Demo1 d1 = new Demo1();
			Dem2 d2 = new Dem2();
			Demo3 d3 = new Demo3();
			
			Thread t1 = new Thread(new D2());
			
			d1.start();
			d2.start();
			t1.start();
		} catch (Exception e) {
			
		}
	}
	
	class Banking {
		static void banking() {
			System.out.println("Banking start");
			Scanner sc = new Scanner(System.in);
			System.out.println("Account Number Input:");
			int an = sc.nextInt();
			System.out.println("Password Input:");
			int pw = sc.nextInt();
			System.out.println("Banking Ends");
		}
	}
	
	class Printer {
		static void printing() throws InterruptedException {
			System.out.println("Printing start");
			for(int i=0; i <10; i++) {
				System.out.println("Yes! "+i);
				Thread.sleep(3000);
			}
			System.out.println("Printing ends");
		}
	}
	
	class Adder {
		static void addition() {
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
	
}
