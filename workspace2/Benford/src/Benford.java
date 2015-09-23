import java.io.File;
import java.util.Scanner;

// This class is Benford class consisting of one filed, the ArrayList object.
// And 3 other methods to help store data in the arraylist.
public class Benford {
	
	int[] counts = new int[10];
	
	public Benford() {
	}
	
	// This method gets a user input data as a parameter,
	// And with a input, read through the data
	// to store leading integer of each number.
	public void readCounts(Scanner input){
		while(input.hasNext()){
			if(input.hasNextInt()){
				int i = input.nextInt();
				counts[firstDigit(i)]++;
			}
			else{
				input.next();
			}
		}
	}
	
	// This method is used to find a leading integer of each number
	// gets a number as a parameter and return a one leading integer.
	public int firstDigit(int i){
		int result = i;
		while(result >= 10){
			result = result / 10;
		}
		return result;
	}
	
	// This method gets a integer arraylist as a parameter and
	// find a percentage of each leading integer about a total number of leading integer.
	// then return a double arraylist.
	public double[] benfordPercent(int[] counts){
		double[] result = new double[10];
		int total = 0;
		
		for (int n : counts){
			total += n;
		}
		
		for(int i =0; i<counts.length; i++){
			double d = counts[i] * 100.0 / total;
			result[i] = d;
		}
		
		return result;
	}
}
