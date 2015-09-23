import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;
import uwcse.io.Input;

/**
 * 
 * Create a program that analyzes DNAs
 * 
 * @author SEUNGHWAN LEE
 * 
 */

public class DNAAnalyzer {

	public static final int NUM_NUCLEOTIDES = 4;
	public static final int NUM_NUCLEOTIDES_PER_CODON = 3;
	public static final double[] MASS = { 135.128, 111.103, 151.128, 125.107 };
	public static final int MINIMUM_CODONS = 4;
	public static final double MINIMUM_PERCENT = 30.0;

	public static void main(String[] args) {
		String title = "This program reports information about DNA\nnucleotide sequences that may encode proteins.";
		System.out.println(title);
		System.out.println();

		String fileName = new Input().readString("Input file name? ");
		System.out.println();
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName));
			while (scan.hasNextLine()) {
				String name = scan.nextLine();
				String sequence = scan.nextLine().toUpperCase();
				System.out.println("Name: " + name);
				System.out.println("Nucleotides: " + sequence);
				// count the nucleotides
				int[] counts = getCounts(sequence);
				System.out.println("Nucleotide counts: "
						+ Arrays.toString(counts));
				double[] percentages = getPercentages(counts);
				System.out.println("Mass percentages: "
						+ Arrays.toString(percentages));
				String[] codons = getCodons(sequence);
				System.out.println("Codons: " + Arrays.toString(codons));
				boolean p = proteinResult(percentages, codons);
				System.out.println("Encodes a proteins: "
						+ ((p) ? "Yes" : "No"));
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " doesn't exist!");
			return;
		}
	}

	/**
	 * 
	 * method to count the number of each nucleotide
	 * 
	 * @param s
	 *            the sequence of DNA
	 * @return the array of numbers of each nucleotide
	 */
	public static int[] getCounts(String s) {
		int cA = 0;
		int cC = 0;
		int cG = 0;
		int cT = 0;
		int count[] = new int[NUM_NUCLEOTIDES];
		for (char c : s.toCharArray()) {
			if (c == 'A') {
				cA++;
			} else if (c == 'C') {
				cC++;
			} else if (c == 'G') {
				cG++;
			} else {
				cT++;
			}

		}
		count[0] = cA;
		count[1] = cC;
		count[2] = cG;
		count[3] = cT;
		return count;
	}

	/**
	 * 
	 * method to calculate the mass percentage of each nucleotide
	 * 
	 * @param count
	 *            the array of the numbers of each nucleotide
	 * @return the array of mass percentages of each nucleotide
	 */
	public static double[] getPercentages(int[] count) {
		double massACGT[] = new double[NUM_NUCLEOTIDES];
		double percentages[] = new double[NUM_NUCLEOTIDES];
		for (int i = 0; i < NUM_NUCLEOTIDES; i++) {
			massACGT[i] = (count[i] * MASS[i]);
		}

		double massTotal = massACGT[0] + massACGT[1] + massACGT[2]
				+ massACGT[3];
		for (int i = 0; i < NUM_NUCLEOTIDES; i++) {
			percentages[i] = getOneDecimal(massACGT[i] / massTotal * 100);
		}
		return percentages;
	}

	/**
	 * 
	 * method to round double value
	 * 
	 * @param d
	 *            the mass percentage of nucleotide
	 * @return the mass percentage with one decimal place
	 */
	public static double getOneDecimal(double d) {
		BigDecimal number = new BigDecimal(d);
		number = number.setScale(1, RoundingMode.HALF_UP);
		return number.doubleValue();
	}
	
	/**
	 * 
	 * method to create array of every 3 nucleotides per codon
	 * 
	 * @param s
	 * 			the sequence of DNA
	 * @return	the array of every 3 nucleotides per codon
	 */
	public static String[] getCodons(String s) {
		String[] codons = new String[s.length() / NUM_NUCLEOTIDES_PER_CODON];
		int count = 0;
		int count2 = 0;
		String r = "";
		for (char c : s.toCharArray()) {
			if (count != 3) {
				r += c;
				count++;
			}
			if (count == 3) {
				codons[count2] = r;
				count = 0;
				r = "";
				count2++;

			}
		}
		return codons;
	}
	
	/**
	 * method to evaluate whether it encodes a protein or not
	 * 
	 * @param c
	 * 			the array of every 3 nucleotides per codon
	 * @param s
	 * 			the array of mass percentage of each nucleotide
	 * @return	true if all conditions are true or false if at least one condition is false
	 */
	public static boolean proteinResult(double[] c, String[] s) {
		boolean condition1 = false;
		boolean condition2 = false;
		boolean condition3 = false;
		boolean condition4 = false;

		if (s[0].equals("ATG")) {
			condition1 = true;
		}
		if (s[s.length - 1].equals("TAA") || s[s.length - 1].equals("TAG")
				|| s[s.length - 1].equals("TGA")) {
			condition2 = true;
		}
		if (s.length >= MINIMUM_CODONS) {
			condition3 = true;
		}
		if (c[1] + c[2] >= MINIMUM_PERCENT) {
			condition4 = true;
		}
		return (condition1 && condition2 && condition3 && condition4);
	}
}
