package Day8;

public class LaunchBirds {
	public static void main(String[] args) {
		Sparrow s = new Sparrow();
		GoldenEagle ge = new GoldenEagle();
		SnakeEagle se = new SnakeEagle();
		
		LaunchBirds.runBirbs(s);
		LaunchBirds.runBirbs(ge);
		LaunchBirds.runBirbs(se);
	}
	
	static void runBirbs(Birb b) {
		b.fly();
		b.eat();
	}
}

abstract class Birb {
	abstract void fly();

	abstract void eat();

}

class Sparrow extends Birb {
	void fly() {
		System.out.println("Sparrow is Flying");
	}

	void eat() {
		System.out.println("Sparrow is Eating");
	}
}

abstract class Eagle extends Birb {
	void fly() {
		System.out.println("This will be overwritten");
	}
}

class GoldenEagle extends Eagle {
	void fly() {
		System.out.println("Golden Eagle is Flying.");
	}
	
	void eat() {
		System.out.println("Golden Eagle is Eating.");
	}
}

class SnakeEagle extends Eagle {
	void fly() {
		System.out.println("Snake Eagle is Flying");
	}
	
	void eat() {
		System.out.println("Golden Eagle is Eating.");
	}
}



