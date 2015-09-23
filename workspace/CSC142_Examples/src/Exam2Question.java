import java.util.ArrayList;

public class Exam2Question {
	// write a method that takes a positive integer n
	// and that returns an integer whose digits are
	// the digits of n in reverse order
	// e.g. if n is 1234, the method returns 4321
	// you can't use a string in your solution
	public static int reverse1stApproach(int n) {
		// Store all of the digits of n
		// in an ArrayList and create the reversed integer
		// from that ArrayList
		ArrayList<Integer> digits = new ArrayList<Integer>();
		do {
			int d = n % 10;
			digits.add(d);
			n /= 10;
		} while (n > 0);

		// check the contents of the ArrayList
		System.out.print("[");
		for (int i = 0; i < digits.size(); i++) {
			System.out.print(digits.get(i)
					+ (i == digits.size() - 1 ? "" : ", "));
		}
		System.out.print("]");
		System.out.println();
		// could have done (toString in the ArrayList class
		// creates a String representation of the ArrayList)
		System.out.println(digits);

		// reverse the integer
		int r = 0;
		for (int i = 0; i < digits.size(); i++) {
			r = r * 10 + digits.get(i);
		}
		return r;
	}

	public static int reverse2ndApproach(int n) {
		// can also do it without an ArrayList
		int r = 0;
		do {
			int d = n % 10;
			r = r * 10 + d;
			n /= 10;
		} while (n > 0);
		return r;
	}

	public static void main(String[] args) {
		System.out.println(reverse1stApproach(1234));
		System.out.println(reverse2ndApproach(1234));
	}
}