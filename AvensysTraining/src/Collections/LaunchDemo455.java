package Collections;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class LaunchDemo455 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		Random random = new Random();
		
		for (int i =0; i <10; i++) {
			int rand = random.nextInt(100);
			System.out.println("Value is: %d".formatted(rand));
			pq.add(rand);
			ts.add(rand);
		}
		System.out.println("Final Check:");
		System.out.println(pq);
		for (int c = 0; c<pq.size(); c++) {
			System.out.println(pq.poll());
			System.out.println(pq);
		}
		System.out.println(ts);
	}
}
