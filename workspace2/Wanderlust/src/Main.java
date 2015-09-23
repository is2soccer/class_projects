import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("This is Travel Destination Program");
		System.out.println("Select one from the option below");
		intro();

	}

	public static Scanner load() {
		try {
			Scanner input = new Scanner(new File("destination.txt"));
			return input;
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File not found");
		}
		return null;
	}

	public static void intro() {
		System.out.println("(1)Add (2)Remove (3)Print out (4)EXIT");
		String name = null;
		Scanner console = new Scanner(System.in);
		System.out.print("Please type 1, 2, 3, or 4: ");
		name = console.nextLine();

		if (name.equals("1")) {
			add();
		} else if (name.equals("2")) {
			remove();
		} else if (name.equals("3")) {
			printOut();
		} else if (name.equals("4")) {
			System.out.println("Thank you for using this program!");
			return;
		} else {
			System.out.println("Please type the right number");
			intro();
		}
	}

	public static void add(){
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> at = new ArrayList<String>();
		Scanner input;
		try {
			input = new Scanner(new File("destination.txt"));
			while(input.hasNextLine()){
				list.add(input.nextLine().toUpperCase());
			}
			for(int i=0; i<list.size()/4; i++){
				at.add(list.get(4*i));
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		
		try{
			FileWriter writer = new FileWriter("destination.txt", true);
			input = new Scanner(System.in);
			System.out.print("Attraction: ");
			String userInput = input.nextLine();
			boolean same = true;
			for(int j=0; j<at.size(); j++){
				if(userInput.toUpperCase().equals(at.get(j))){
					same = true;
				}else{
					same = false;
				}
			}if(same){
				writer.close();
				System.out.println("You Already Have The Same Attraction In Your List");
			}else{
				writer.write(userInput);
				writer.write("\r\n");
				
				System.out.print("City: ");
				writer.write(input.nextLine());
				writer.write("\r\n");
				
				System.out.print("Country: ");
				writer.write(input.nextLine());
				writer.write("\r\n");
				
				System.out.print("Distance from Seattle: ");
				writer.write(input.nextLine());
				writer.write("\r\n");
				writer.close();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		intro();
	}

	public static void remove() {
		File inputFile = new File("destination.txt");
		File tempFile = new File("destinationTemp.txt");
		ArrayList<String> list = new ArrayList<String>();
		try {
			Scanner reader = new Scanner(new FileReader(inputFile));
			inputFile.delete();
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			Scanner input = new Scanner(System.in);
			System.out.print("Name of attraction you want to remove: ");
			String atremove = input.nextLine();

			while (reader.hasNext()) {
				list.add(reader.nextLine());
			}
			for (int i = 0; i < (list.size() / 4); i++) {
				if (list.get(4 * i).equals(atremove)) {
					list.remove(4 * i);
					list.remove(4 * i);
					list.remove(4 * i);
					list.remove(4 * i);
					i--;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				writer.write(list.get(i));
				writer.write("\r\n");
			}
			writer.close();
			reader.close();
			if (tempFile.renameTo(new File("destination.txt"))) {
				System.out.println("Delete Success");
			} else {
				System.out.println("Delete failed");
			}
			tempFile.delete();

		} catch (IOException e) {
			e.printStackTrace();
		}
		intro();
	}

	public static void printOut() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> at = new ArrayList<String>();
		ArrayList<String> ct = new ArrayList<String>();
		ArrayList<String> co = new ArrayList<String>();
		ArrayList<Double> di = new ArrayList<Double>();
		
		ArrayList<Destination> de = new ArrayList<Destination>();
		Scanner input;
		try {
			input = new Scanner(new File("destination.txt"));
			while (input.hasNextLine()) {
				list.add(input.nextLine());
			}
			for (int i = 0; i < list.size() / 4; i++) {
				de.add(new Destination(list.get(4*i),list.get(4*i+1),list.get(4*i+2),Double.parseDouble(list.get(4*i+3))));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
		Scanner input2 = new Scanner(System.in);
		String userInput = null;
		LinkedList byAt = new LinkedList();
		LinkedList byCt = new LinkedList();
		do{
			System.out.print("(1)By attration (2) By city : ");
			userInput = input2.nextLine();
			if(userInput.equals("1")){
				Collections.sort(de);
				for(int i=0; i<de.size(); i++){
					byAt.add(new ListNode(de.get(i).getAttraction(),de.get(i).getCity(),de.get(i).getCountry(),de.get(i).getDistance()));
					System.out.println("Attraction Name: " + de.get(i).getAttraction());
					System.out.println("Attraction City: " + de.get(i).getCity());
					System.out.println("Attraction Country: " + de.get(i).getCountry());
					System.out.println("Distance from Seattle: " + de.get(i).getDistance());
				}
			}else if(userInput.equals("2")){
				Collections.sort(de, new Comparator<Destination>(){
					@Override
					public int compare(Destination o1, Destination o2) {
						int ct = o1.getCity().toUpperCase().compareTo(o2.getCity().toUpperCase());
						return ct;
					}
				});
				for(int i=0; i<de.size(); i++){
					byCt.add(new ListNode(de.get(0).getAttraction(),de.get(0).getCity(),de.get(0).getCountry(),de.get(0).getDistance()));
					System.out.println("Attraction Name: " + de.get(i).getAttraction());
					System.out.println("Attraction City: " + de.get(i).getCity());
					System.out.println("Attraction Country: " + de.get(i).getCountry());
					System.out.println("Distance from Seattle: " + de.get(i).getDistance());
				}
			}
		}while(userInput == null);
	}

}
