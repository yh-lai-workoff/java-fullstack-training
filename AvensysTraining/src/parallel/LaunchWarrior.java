package parallel;

class Warrior extends Thread{
	String resource1 = "knife";
	String resource2 = "gun";
	String resource3 = "bomb";
	
	
	public void run() {
		if (getName().equals("ramu"))
			getRajResources();
		else {
			getRamResource();
		}
	}
	
	void getRamResource(){
		try {
			synchronized (resource1) {
				System.out.println("I've got a knife!");
				Thread.sleep(4000);
				synchronized (resource2) {
					System.out.println("I've got a gun!");
					Thread.sleep(4000);
					synchronized (resource3) {
						System.out.println("I've got a bomb!");
						Thread.sleep(4000);
					}
				}
			}
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void getRajResources() {
		try {
			synchronized (resource3) {
				System.out.println("I've got a bomb!");
				Thread.sleep(4000);
				synchronized (resource2) {
					System.out.println("I've got a gun!");
					Thread.sleep(4000);
					synchronized (resource1) {
						System.out.println("I've got a knife!");
						Thread.sleep(4000);
					}
				}
			}
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class LaunchWarrior {
	public static void main(String[] args) {
		Warrior ramu = new Warrior();
		Warrior raju = new Warrior();
		ramu.setName("ramu");
		raju.setName("raju");
		
		ramu.start();
		raju.start();
		
		
	}
}
