package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ConciseComparator {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.addAll(Arrays.asList(new Integer[] {1,2,3,4,5,6,7}));
		System.out.println(al);
		
		Collections.sort(al, (obj1,obj2)->(obj1<obj2)?1:(obj1>obj2)?-1:0);
		System.out.println(al);
		
	}
}
