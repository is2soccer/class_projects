import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Baby {

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> babyF = new HashMap<>();
		Map<String, Integer> babyM = new HashMap<>();

		TreeSet<String> nameF = new TreeSet<String>();
		TreeSet<String> nameM = new TreeSet<String>();

		// I assume my name is Kevin, because my real name will result 0
		String myName = "Kevin";

		Scanner in = new Scanner(new File("names_2013.txt"));
		while (in.hasNext()) {
			String word = in.next();
			String[] values = word.split(",");
			if (values[1].equals("F")) {
				String name = values[0];
				int n = Integer.parseInt(values[2]);
				babyF.put(name, n);
				nameF.add(name);
			} else {
				String name = values[0];
				int n = Integer.parseInt(values[2]);
				babyM.put(name, n);
				nameM.add(name);
			}

		}
		int uniqueF = unique(babyF, nameM);
		System.out.println("Number of unique female names: " + uniqueF);

		int uniqueM = unique(babyM, nameF);
		System.out.println("Number of unique male names: " + uniqueM);

		System.out.println("Number of unisex names: "
				+ (babyF.size() - uniqueF));

		int sameFName = findName(babyF, myName);
		System.out.println("Number of female babies who have same name: "
				+ sameFName);
		int sameMName = findName(babyM, myName);
		System.out.println("Number of male babies who have same name: "
				+ sameMName);
	}

	public static int unique(Map<String, Integer> map, TreeSet<String> name) {
		Iterator<String> it = name.iterator();
		int counts = 0;
		while (it.hasNext()) {
			if (map.containsKey(it.next())) {
				counts++;
			}
		}
		int result = map.size() - counts;
		return result;
	}

	public static int findName(Map<String, Integer> map, String myName) {
		return map.get(myName);
	}

}
