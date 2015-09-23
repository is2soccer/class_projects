import java.util.Arrays;

import uwcse.graphics.Rectangle;


public class Example2 {
	
	public double x; // visibility -> all classes
	int k; // Example2 + all other classes in the same pakage
	private int j; // Example2 only
	public static void main(String[] args){
		f(10,5.6); // V1
		f(1.2, 5); // V2
		// What if I write: f(5,10);
		// f(5,10); -> can't tell : ambiguous call
		
		// What is in String[] args
		System.out.println("args = " + Arrays.toString(args));
		
		Rectangle r;
	}
	
	public static void f(int k, double x){
		// Version1
	}
	
	public static void f(double x, int k){
		// Version2
	}
}
