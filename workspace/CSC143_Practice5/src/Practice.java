import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;


public class Practice {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args){
		HashSet<String> BookA_hash = new HashSet<String>();
		TreeSet<String> test = new TreeSet<String>();
		TreeSet<Integer> tree = new TreeSet<Integer>();
		Scanner in = new Scanner(new File("1.txt"));
		while(in.hasNext()){
			String word = in.next();
			word = word.toLowerCase();
			BookA_hash.add(word);
		}
		while(in.hasNext()){
			String word = in.next();
			word = word.toLowerCase();
			BookA_tree.add(word);
		}

	}

}
