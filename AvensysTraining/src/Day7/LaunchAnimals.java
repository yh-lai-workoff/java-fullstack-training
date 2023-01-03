package Day7;

class Animal {
	void eat() {
		System.out.println("Generally use your mouth");
	}

	void sleep() {
		System.out.println("Lay down and close eyes");
	}

	void food() {
		System.out.println("Anything on earth.");
	}
	Animal createAnimal() {
		return new Animal();
	}
}

/**
 * 
 * @author Lai Yan Hong
 * 
 *
 */
class Tiger extends Animal {
	void eat() {
		System.out.println("Hunt and Keel");
	}

	void food() {
		System.out.println("Carnivore");
	}
	
	Tiger createAnimal() {
		return new Tiger();
	}
}

class Deer extends Animal {
	void eat() {
		System.out.println("Graze and chew.");
	}

	void food() {
		System.out.println("Herbivore");
	}
}

class Monkey extends Animal {
	void eat() {
		System.out.println("Pluck and nom");
	}

	void food() {
		System.out.println("Omnivore");
	}
}

class Zoo {
	void observe(Animal animal) {
		animal.eat();
		animal.sleep();
		animal.food();
	}
}

public class LaunchAnimals {
	public static void main(String[] args) {
		Tiger tiger = new Tiger();
		Deer deer = new Deer();
		Monkey monkey = new Monkey();

		Zoo z = new Zoo();
		z.observe(tiger);
		z.observe(deer);
		z.observe(monkey);

	}
}
