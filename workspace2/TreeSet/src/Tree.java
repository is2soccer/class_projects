import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class Tree {
	static HashSet<String> BookA_hash = new HashSet<String>();
	static TreeSet<String> BookA_tree = new TreeSet<String>();
	
	static HashSet<String> BookB_hash = new HashSet<String>();
	static TreeSet<String> BookB_tree = new TreeSet<String>();

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("1.txt"));
		while(in.hasNext()){
			String word = in.next();
			word = word.toLowerCase();
			BookA_hash.add(word);
			BookA_tree.add(word);
		}
		Scanner in2 = new Scanner(new File("2.txt"));
		while(in2.hasNext()){
			String word = in2.next();
			word = word.toLowerCase();
			BookB_hash.add(word);
			BookB_tree.add(word);
		}

		
		
		long startTime = System.nanoTime();
		Iterator<String> a_hash_it = BookA_hash.iterator();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Iterate hashset duration: "+duration+"ns");
		
		startTime = System.nanoTime();
		Iterator<String> a_tree_it = BookA_tree.iterator();
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Iterate treeset duration: "+duration+"ns");
		
		startTime = System.nanoTime();
		while(a_hash_it.hasNext()){
			if(BookB_hash.contains(a_hash_it.next())){
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Iterate through the words in BookA_hash and search for these words in BookB_hash: "+duration+"ms");
		
		Iterator<String> a_hash_it2 = BookA_hash.iterator();
		startTime = System.nanoTime();
		while(a_hash_it2.hasNext()){
			if(BookB_tree.contains(a_hash_it2.next())){
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Iterate through the words in BookA_hash and search for these words in BookB_tree: "+duration+"ms");
		
		startTime = System.nanoTime();
		while(a_tree_it.hasNext()){
			if(BookB_hash.contains(a_tree_it.next())){
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Iterate through the words in BookA_tree and search for these words in BookB_hash: "+duration+"ms");
		
		Iterator<String> a_tree_it2 = BookA_tree.iterator();
		startTime = System.nanoTime();
		while(a_tree_it2.hasNext()){
			if(BookB_tree.contains(a_tree_it2.next())){
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Iterate through the words in BookA_tree and search for these words in BookB_tree: "+duration+"ms");
		Iterator<String> b_hash_it = BookB_hash.iterator();
		
		startTime = System.nanoTime();
		while(b_hash_it.hasNext()){
			if(BookA_hash.contains(b_hash_it.next())){
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Iterate through the words in BookB_hash and search for these words in BookA_hash: "+duration+"ms");
		
		Iterator<String> b_hash_it2 = BookB_hash.iterator();
		
		startTime = System.nanoTime();
		while(b_hash_it2.hasNext()){
			if(BookA_tree.contains(b_hash_it2.next())){
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Iterate through the words in BookB_hash and search for these words in BookA_tree: "+duration+"ms");
		
		Iterator<String> b_tree_it = BookB_tree.iterator();
		
		startTime = System.nanoTime();
		while(b_tree_it.hasNext()){
			if(BookA_hash.contains(b_tree_it.next())){
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Iterate through the words in BookB_tree and search for these words in BookA_hash: "+duration+"ms");
		
		Iterator<String> b_tree_it2 = BookB_tree.iterator();
		
		startTime = System.nanoTime();
		while(b_tree_it2.hasNext()){
			if(BookA_tree.contains(b_tree_it2.next())){
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Iterate through the words in BookB_tree and search for these words in BookA_tree: "+duration+"ms");
	}

}
