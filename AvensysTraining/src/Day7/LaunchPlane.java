package Day7;

class Plane {
	void takeOff() {
		System.out.println("Plane is taking off.");
	}

	void fly() {
		System.out.println("Plane is flying.");
	}

	void fly(String text) {
		System.out.println("Plane is flyinggggg.");
	}

	void land() {
		System.out.println("Plane is landing.");
	}
	
}

class PassengerPlane extends Plane {
	void fly() {
		System.out.println("Plane is totally flying.");
	}

	void carryPassenger() {
		System.out.println("Plane is carrying Passerngers.");
	}
	
}

class CargoPlane extends Plane {
	void fly() {
		System.out.println("Flying medium");
	}

	public void carryCargo() {
		System.out.println("That's a lot of grain!");
	}
}

class FighterPlane extends Plane {
	void fly() {
		System.out.println("Flying High");
	}

	void carryWeapons() {
		System.out.println("This baby is loaded man.");
	}
}

class Airport {
	void permit(Plane plane) {
		plane.takeOff();
		plane.fly();
		plane.land();
	}

	void runSpecial(Plane plane) {
		if (plane instanceof PassengerPlane)
			((PassengerPlane) plane).carryPassenger();
		else if (plane instanceof CargoPlane)
			((CargoPlane) plane).carryCargo();
		else if (plane instanceof FighterPlane)
			((FighterPlane) plane).carryWeapons();
	}

}

public class LaunchPlane {
	public static void main(String[] args) {
		PassengerPlane pp = new PassengerPlane();
		CargoPlane cp = new CargoPlane();
		FighterPlane fp = new FighterPlane();

		Airport ap = new Airport();
		ap.permit(pp);
		ap.runSpecial(pp);
		ap.permit(cp);
		ap.runSpecial(cp);
		ap.permit(fp);
		ap.runSpecial(fp);

	}
}
