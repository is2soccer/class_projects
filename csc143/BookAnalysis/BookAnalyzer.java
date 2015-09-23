import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class BookAnalyzer {
	static HashSet<String> pos_hash = new HashSet<String>();
	static HashSet<String> neg_hash = new HashSet<String>();
	static ArrayList<String> book_arraylist = new ArrayList<String>();
	static String posWord;
	static int maxPosWord;
	static String negWord;
	static int maxNegWord;
	
	public BookAnalyzer(Scanner pos, Scanner neg, Scanner book){
		while (pos.hasNext()) {
			String word = pos.next();
			word = word.toLowerCase();
			pos_hash.add(word);
		}
		while (neg.hasNext()) {
			String word = neg.next();
			word = word.toLowerCase();
			neg_hash.add(word);
		}
		while (book.hasNext()) {
			String word = book.next();
			word = word.toLowerCase();
			book_arraylist.add(word);
		}
	}
	public static int getWordCount(){
		return book_arraylist.size();
	}
	public static int getPosWordCount(){
		maxPosWord = 0;
		int countPosWord = 0;
		int counts = 0;
		Iterator<String> pos_it = pos_hash.iterator();
		while(pos_it.hasNext()){
			String s = pos_it.next();
			for(int i =0; i<book_arraylist.size(); i++){
				if((book_arraylist.get(i)).contains(s)){
					counts ++;
					countPosWord ++;
				}
			}
			if(countPosWord > maxPosWord){
				posWord = pos_it.next();
				maxPosWord = countPosWord;
			}
			countPosWord = 0;
		}
		return counts;
	}
	public static int getNegWordCount(){
		maxNegWord = 0;
		int countNegWord = 0;
		int counts = 0;
		Iterator<String> neg_it = neg_hash.iterator();
		while(neg_it.hasNext()){
			String s = neg_it.next();
			for(int i =0; i<book_arraylist.size(); i++){
				if((book_arraylist.get(i)).contains(s)){
					counts ++;
					countNegWord ++;
				}
			}
			if(countNegWord > maxNegWord){
				negWord = neg_it.next();
				maxNegWord = countNegWord;
			}
			countNegWord = 0;
		}
		return counts;
	}
}
