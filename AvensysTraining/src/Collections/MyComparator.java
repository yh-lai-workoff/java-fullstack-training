package Collections;

import java.util.Comparator;
import java.util.TreeSet;

class Compositer implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if ((Integer) o1 < (Integer)o2)
			return 1;
		else if ((Integer)o1 > (Integer)o2)
			return -1;
		return 0;
	}
	
}

public class MyComparator {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new Compositer());
		ts.add(100);
		ts.add(100);
		ts.add(100);
		ts.add(200);
		ts.add(500);
		System.out.println(ts);
	}

}
