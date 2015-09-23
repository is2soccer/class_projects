package ex;

// Original method took 13840636660 nano seconds.
//      New method took     1245453 nano seconds.    
// I think fibonacci method is not needed to be efficient,
// We can simply store two numbers in two different variable and
// keep adding them and replace one and the other each time.
public class Fibonacci {

	public static void main(String[] args) {
		long start = System.nanoTime();
		int n1 = 0;
		int n2 = 0;
		for (int i = 0; i < 46; i++) {
			if (i == 0) {
				n1 = 1;
				System.out.println("Fibonacci(" + i + ") = " + n1);
			} else if (i == 1) {
				n2 = 1;
				System.out.println("Fibonacci(" + i + ") = " + n2);
			} else if (i % 2 == 0) {
				n1 = n1 + n2;
				System.out.println("Fibonacci(" + i + ") = " + n1);
			} else {
				n2 = n1 + n2;
				System.out.println("Fibonacci(" + i + ") = " + n2);
			}
		}
		long end = System.nanoTime();
		System.out.println(end - start);
	}

}