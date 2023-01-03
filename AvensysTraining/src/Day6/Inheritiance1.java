package Day6;

public class Inheritiance1 {
	public static void main(String[] args) {
		Demo1 dem1 = new Demo1();
		Demo2 dem2 = new Demo2();
		
		System.out.println(dem2.count);
		System.out.println(dem1.count);
		System.out.println(dem2);
		dem2.display();
		
	}
}

class Demo1{
	int count = 1;

	void increaseCount() {
		count++;
	}
}

class Demo2 extends Demo1 {
	int count = 2;
	void display () {
		int count = 3;
		System.out.println(count);
		System.out.println(this.count);
		System.out.println(super.count);
		int[] tester = new int[10];
		System.out.println(tester[0]);

	}
	
}

abstract class test2{
	public static void main(String[] args) {
		
	}
}

interface test {
	void print();
}
class Demo3 extends Demo1{
	
}

//class Demo4 extends Demo5{
//	
//}
//
//class Demo5 extends Demo4{
//	
//}

class Demo6 extends Demo2{
	int count = 4;
	
	void display() {
		System.out.println();
	}
}


