package parallel;

import java.util.Iterator;

/*
 * Thread 1: Typing
 * Thread 2: Spell-check
 * Thread 3: Auto-Save
 */

class MSWord extends Thread{
	public void run() {
		String name = getName();
		if (name.equals("TYPE"))
			typing();
		else if (name.equals("CHECK"))
			spellCheck();
		else if (name.equals("SAVE"))
			autoSave();
	}
	
	void typing() {
		try {
			for(int i=0; i<5; i++) {
				System.out.println("Typing...");
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	void spellCheck() {
		try {
			while(true) {
				System.out.println("Checking...");
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	void autoSave() {
		try {
			while(true) {
				System.out.println("Saving...");
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

public class LaunchMSWord {
	public static void main(String[] args) {
		MSWord m1 = new MSWord();
		MSWord m2 = new MSWord();
		MSWord m3 = new MSWord();
		
		m1.setName("TYPE");
		m2.setName("CHECK");
		m3.setName("SAVE");
		
		m2.setDaemon(true);
		m3.setDaemon(true);
		
		m2.setPriority(8);
		m3.setPriority(9);
		
		m1.start();
		m2.start();
		m3.start();
	}
}
