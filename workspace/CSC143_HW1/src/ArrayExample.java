import java.util.ArrayList;

public class ArrayExample {
	// Write a method that takes an ArrayList of String objects
	// and that changes the ArrayList such that
	// the first element appears once
	// the second element appears twice
	// the third element appears three times
	// and so on.
	// Example: if the ArrayList is initially
	// {"a", "b", "c", "d"}
	// After calling the method the ArrayList is changed to
	// {"a", "b", "b", "c", "c", "c", "d", "d", "d", "d"}
	// We can't use another ArrayList in our solution
	public static void multiply1(ArrayList<String> a) {
		// 1st way
		int k = 1; // number of insertions
		for (int i = 1; i < a.size(); i++) {
			String s = a.get(i);
			for (int j = 1; j <= k; j++) {
				a.add(i, s);
			}
			i += k;
			k++;
		}
	}

	public static void multiply2(ArrayList<String> a) {
		// 2nd way (much simpler)
		for (int i = a.size() - 1; i >= 1; i--) {
			String s = a.get(i);
			for (int j = 0; j < i; j++) {
				a.add(i, s);
			}
		}
	}

	// To test the method multiply
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println("Before: list = " + list);
		multiply1(list);
		System.out.println("After: list = " + list);

		list.clear();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println("Before: list = " + list);
		multiply2(list);
		System.out.println("After: list = " + list);
	}
}