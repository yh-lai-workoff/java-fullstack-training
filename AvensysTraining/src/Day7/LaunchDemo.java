package Day7;

public class LaunchDemo {
	public static void main(String[] args) {
		Demo2 dem2 = new Demo2(20, 20);
		dem2.display();
	}
}

class Demo1 {
	int a, b;

	Demo1() {
		System.out.println("Hidden Super will be called here.");
		a = 10;
		b = 20;
	}

	Demo1(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

class Demo2 extends Demo1 {
	int c, d;

	Demo2() {
		System.out.println("This will be proof.");
		c = 11;
		d = 22;
	}

	Demo2(int a, int b) {
		super(10, 22);
		c = a;
		d = b;
	}

	void display() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}