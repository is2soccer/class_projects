import java.util.ArrayList;


public class IndexOf {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("The classification of cats");
		a.add("staccato");
		a.add("catamaran");
		a.add("the caterpilar and the bobcat");
		keywordCount(a, "c");

	}
	public static int keywordCount(ArrayList<String> listOfStrings, String s){
		int count = 0;
		for(int i = 0; i<listOfStrings.size(); i++){
			String n = listOfStrings.get(i);
			int j = 0;
			for(int k=0; k<n.length(); k++){
				if(n.indexOf(s,k) != -1){
					count++;
					k=n.indexOf(s,k);
				}
			}
		}
		System.out.println(count);
		return count;
	}
}
