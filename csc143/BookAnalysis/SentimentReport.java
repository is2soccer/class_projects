import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SentimentReport {
	
	public static final boolean TEST_MODE = true;
	static String bookName = null;
	static long start;
	static long end;

	public static void main(String[] args){
		
		intro();
		
		Scanner input1 = null;
		Scanner input2 = null;
		Scanner input3 = null;
		
		if(TEST_MODE){
			
			try {
				input1 = new Scanner(new File("posWords.txt"));
			} catch (FileNotFoundException ex) {
				System.out.println("Error: File now found");
			}
			try {
				input2 = new Scanner(new File("negWords.txt"));
			} catch (FileNotFoundException ex) {
				System.out.println("Error: File now found");
			}
			String name = null;
			Scanner console = new Scanner(System.in);
			System.out.println("Try to type \"Macbeth.txt\" to analyze Macbeth");
			System.out.println("    or type \"MuchAdoAboutNothing.txt\" to analyze Much A do About Nothing");
			do{
				try {
					
					System.out.print("File name of the book?: ");
					name = console.nextLine();
					input3 = new Scanner(new File(name));
					bookName = name;
				} catch (FileNotFoundException ex) {
					System.out.println("Error: File now found");
					name = null;
				}
			}while (name == null);
			
		}else{
			String name = null;
			Scanner console = new Scanner(System.in);
			do{
				System.out.print("File name of positive words?: ");
				name = console.nextLine();
				try{
					input1 = new Scanner(new File(name));
				}
				catch (FileNotFoundException ex){
					System.out.println("Error: File not found");
					name = null;
				}
				
			}while (name == null);
			do{
				System.out.print("File name of negative words?: ");
				name = console.nextLine();
				try{
					input2 = new Scanner(new File(name));
				}
				catch (FileNotFoundException ex){
					System.out.println("Error: File not found");
					name = null;
				}
				
			}while (name == null);
			do{
				System.out.print("File name of book?: ");
				name = console.nextLine();
				bookName = name;
				try{
					input3 = new Scanner(new File(name));
				}
				catch (FileNotFoundException ex){
					System.out.println("Error: File not found");
					name = null;
				}
				
			}while (name == null);
		}
		start = System.nanoTime();
		BookAnalyzer b = new BookAnalyzer(input1, input2, input3);
		getReport(b);
		
		
		

	}
	public static void getReport(BookAnalyzer b){
		int totalWord = b.getWordCount();
		int posWord = b.getPosWordCount();
		int negWord = b.getNegWordCount();
		System.out.println("This is the report on the book \""+bookName+"\"");
		
		System.out.println("Total number of words in the book:           "+totalWord);
		System.out.println("Total number of positive words in the book:  "+posWord);
		System.out.println("The % of positive words:                     "+ String.format("%.2f",(posWord*100.0/totalWord))+"%");
		System.out.println("The most commonly occurring positive word :  " +b.posWord);
		System.out.println("            the number of times it occurs :  " +b.maxPosWord);
		
		System.out.println("Total number of negative words in the book:  "+negWord);
		System.out.println("The % of negative words:                     "+ String.format("%.2f",(negWord*100.0/totalWord))+"%");
		System.out.println("The most commonly occurring negative word :  " +b.negWord);
		System.out.println("            the number of times it occurs :  " +b.maxNegWord);
		if(posWord>negWord){
			System.out.println("This book is comedy");
		}else if(negWord>posWord){
			System.out.println("This book is tragedy");
		}else{
			System.out.println("This book is boring");
		}
		end = System.nanoTime();
		long duration = end - start;
		System.out.println("The time used in completing the book analysis: " + duration / 1000000 + "ms");
	}
	private static void intro(){
		System.out.println("This Program is to analyze on the book you choose by using the positive and negative words");
		System.out.println("You will need 3 text file: positive words, negative words, and the book you want to analyze");
		System.out.println("As you provide 3 text file, this program will analyze the book and give you reports");
		
		}

}
