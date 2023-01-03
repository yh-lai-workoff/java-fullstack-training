package Day6;

public class NewDogExample {
	public static void main(String[] args) {
		System.out.println("Program Start");
		Dog.countTheDogs();
		Dog dog1 = new Dog();
		Dog.countTheDogs();
		Dog dog2 = new Dog();
		Dog dog3 = new Dog();
		Dog.countTheDogs();
		Dog dog4 = new Dog();
		Dog dog5 = new Dog("Albert", "Brown", 5000);
		Dog dog6 = new Dog();
		Dog.countTheDogs();
	}
}

class Dog {
	static int dogCount = 0;

	String name;
	String color;
	int cost;
	
	static {
		System.out.println("WOW");
	}
	
	{
		System.out.println("Runs before constructors");
	}

	Dog() {
		dogCount++;
		System.out.println("Running COnstructor");
	}

	Dog(String name, String color, int cost) {
		dogCount++;
		this.name = name;
		this.color = color;
		this.cost = cost;
	}

	static void countTheDogs() {
		System.out.println(dogCount);
	}

	void bark() {
		System.out.println("Bark");
	}

	void run() {
		System.out.println("Dog is running");
	}

}